var Pub = (function (pub) {
    //表单序列化为JSON对象
    function formToJson(formId) {
        var jsonObj = {};
        var formSerializeArr = $("#" + formId).serializeArray();
        //将json数组转化为一个json对象
        $.each(formSerializeArr, function () {
            if (jsonObj[this.name]) {
                if (!jsonObj[this.name].push) {
                    jsonObj[this.name] = [jsonObj[this.name]];
                }
                jsonObj[this.name].push(this.value || "");
            } else {
                jsonObj[this.name] = this.value || "";
            }
        });

        return jsonObj;
    }

    String.prototype.oTemp = function (obj,i) {
        return this.replace(/\$\w+\$/gi, function (matchs) { 
            var returns = obj[matchs.replace(/\$/g, "")];
            if (matchs == '$idx$') {
                returns = i;
            }
            if (matchs == '$cashStas$') {
                var _s = obj['status'];
                if (_s == 1) {
                    returns = '已打款';
                } else {
                    returns = '申请中';
                }
            }
            if (matchs == '$zt$') {
                var _s = obj['status'];
                if (_s == 0) {
                    returns = '待付款';
                } else if (_s == 20) {
                    returns = '未使用';
                  
                } else if (_s == 21) {
                    returns = '已使用';

                } else if (_s == 4) {
                    returns = '已取消'; 
                } else {
                    returns = '未知状态'; 
                }
            } 
            return (returns + "") == "undefined" ? "" : returns;
        });
    };
    //模板渲染数据
    function aTemp(d, _html) {
        var htmlList = '';
        for (var i = 0; i < d.length; i++) {
            htmlList += _html.oTemp(d[i],i);
        }
        return htmlList;
    };

    function loadHtml(objs, formId) {//根据Id填充数据objs:数据formId:父级对象
        var formObj = $("#" + formId), namObj;
        $.each(objs, function (nam, val) {
            if (val == null) val = '';
            namObj = formObj.find("#" + nam);
            if (namObj.length === 0) return; 
            namObj.text(val); 
        });
    }
    function flyPoint(x, y, top) {
        $('<div class="u-flyer black"/>').fly({
            start: { left: x, top: y }, end: { left: 34, top: top },
            onEnd: function () { this.destory() }
        });
    }

    function conMsg(con, fn) {
        Pub.tip({
            content: '确定要' + con + '吗？', btn: ['确定', '取消'],
            yes: function (index) { fn(); layer.close(index) }
        })
    };
    //微信支付
    function wxPay(data, oid) {
        //alert(JSON.stringify('asd' + data));
        var _data = $.parseJSON(data);
        if (_data && _data !== "") {
            WeixinJSBridge.invoke('getBrandWCPayRequest', {
                'appId': _data.appId,
                'timeStamp': _data.timeStamp,
                'nonceStr': _data.nonceStr,
                'package': _data.package,
                'signType': _data.signType,
                'paySign': _data.paySign
            }, function (res) { 
                if (res.err_msg === 'get_brand_wcpay_request:ok') {
                    var oauth = JSON.parse($.cookie('oauth'));
                    oauth.mu_type = '1';
                    Pub.setCookie('oauth', JSON.stringify(oauth));
                    location.replace('/Lubricant/OrderDetail?id=' + oid + 's20'); 
                }  
            }); 
        }
    };

    return {
        ajaxCRUD: function (d, f, c) {
            if (c || false) {
                $.post('/Ticket/PostOCHttp', JSON.stringify(d), f);
            } else {
                $.post('/Ticket/PostHttp', JSON.stringify(d), f);
            }

        },
        formToJson: formToJson,
        aTemp: aTemp,
        loadHtml:loadHtml,
        wxPay: wxPay,
        confirm: function (msg,fn) {
            layer.open({
                content: msg, btn: ['确认', '取消'],
                yes: function (index) {
                    fn();
                    layer.close(index);
                }
            });
        },
        tip: function (opts) {
            var sets = {
                content: '',
                shadeClose: false,
                btn: ['朕知道了']
            };

            sets = $.extend(sets, opts);

            layer.open(sets);
        },
        msgTip: function (msg) {
            layer.open({ skin: "msg", time: 1, content: msg });
        }, 
        cusFixed: function (n) {
            var tmp = n + '', arr = tmp.split(".");
            if (arr.length > 1) tmp = Number(n).toFixed(2);
            return tmp;
        },
        inputPro: function (val) {
            val = val.replace(/[^\d.]/g, "");//非数字的都替换掉，除了数字和. 
            val = val.replace(/^\./g, ""); //保证第一个为数字而不是. 
            val = val.replace(".", "$#{1}").replace(/\./g, "").replace("$#{1}", ".");//.只出现一次，而不能出现两次以上
            if (val.indexOf('.') >= 0 && val.split('.')[1].length > 2) {
                val = Number(val).toFixed(2) + '';
            }
            val = val.substr(0, 6);
            return val;
        },
        inputNum: function (t, len, check) {
            var val = t.value;
            val = val.replace(/[^\d]/g, '');//非数字的都替换掉
            if (check || false) val = val.replace(/^[0,2-9]/, '');//保证第一个为1
            val = val.substr(0, len);
            t.value = val;
        },
        showLoad: function () {
            $("#loading").show()
        },
        hideLoad: function () {
            $("#loading").fadeOut()
        },
        cScroll: function (id, opts) {
            if (opts == undefined) opts = {};
            var sets = { tap: false, bounce: false,click:true };
            sets = $.extend(sets, opts);
            return new IScroll('#'+id, sets);
        },
        imgNoFind: function (img) {
            img.src = "/Css/img/default.png";
            img.onerror = null;
        },

        conMsg: conMsg,
        flyPoint: flyPoint,
        getUrlParam: function () {
            var result = {};
            var params = (window.location.search.split('?')[1] || '').split('&');
            for (var param in params) {
                if (params.hasOwnProperty(param)) {
                    paramParts = params[param].split('=');
                    result[paramParts[0]] = decodeURIComponent(paramParts[1] || "");
                }
            }
            return result;
        },
        locationUrl: function (u) {
            location.replace(u);
        },
        versions: function () {//浏览器检测
            var u = navigator.userAgent, app = navigator.appVersion;
            return {
                trident: u.indexOf('Trident') > -1, //IE内核
                presto: u.indexOf('Presto') > -1, //opera内核
                webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
                gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1,//火狐内核
                mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端
                ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
                android: u.indexOf('Android') > -1 || u.indexOf('Adr') > -1, //android终端
                iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者QQHD浏览器
                iPad: u.indexOf('iPad') > -1, //是否iPad
                webApp: u.indexOf('Safari') == -1, //是否web应该程序，没有头部与底部
                weixin: u.indexOf('MicroMessenger') > -1, //是否微信 （2015-01-22新增）
                qq: u.match(/\sQQ/i) == " qq" //是否QQ
            };
        }, 
        getCode: function (t) {
            var obj = $(t), tel = obj.parents('.layCon').find("#telNum");
            if (!obj.hasClass('disa') && Pub.validate(11, tel[0], '手机号', /^1\d{10}$/)) {
                obj.addClass('disa');
                $.post('/User/SendVerificationCode',
                    { mobile: tel.val() },
                    function (d) {
                        if (d && d.Code == 0) {
                            $("#otherPho").parent().removeClass('logined');
                            Pub.msgTip(d.Msg);

                            var times = 61;
                            setTime = setInterval(function () {
                                times--;
                                if (times <= 0) {
                                    clearInterval(setTime); 
                                    obj.removeClass('disa').text('获取验证码')
                                } else {
                                    obj.text(times + 's')
                                }
                            }, 1000);

                        } else if (d.Code == 2) {
                            $("#otherPho").text('此手机已在其它微信账号验证').parent().addClass('logined');
                        } else {
                            Pub.msgTip(d.Msg)
                        }
                        if (d.Code != 0) obj.removeClass('disa');
                    })
            }
        },
        login: function (t) { 
            var obj = $(t), vOb = obj.prev(), isAll = true,
                tObj = vOb.find("#telNum"),
                cObj = vOb.find("#codNum"),
                tel = tObj.val(),
                cod = cObj.val();
            if (!Pub.validate(11, tObj[0], '手机号', /^1\d{10}$/)) {
                isAll = false;
            }
            if (isAll && !Pub.validate(6, cObj[0], '验证码', /\d/)) {
                isAll = false;
            } 
            if (isAll) { 
                $.post('/User/RegisterMember',
                    { mobile: tel, send_code: cod },
                    function (d) { 
                        if (d && d.Code == 0) {
                            Pub.msgTip('验证成功');
                           // uInfo.mobile = tel;

                            uCook = $.cookie('oauth');
                            if (uCook) uInfo = $.extend(uInfo, JSON.parse(uCook));
                            $.each(uInfo, function (i, v) { if (typeof (v) != 'number') uInfo[i] = v || '' }); 

                            if ($('#mobile').length) { $('#mobile').text(tel); }
                            if ($('#headimgurl').length) { $('#headimgurl').attr('src', uInfo.headimgurl); } 
                            Pub.hideLogin();
                        } else { 
                            Pub.msgTip('验证失败：'+d.Msg)
                        }
                    })
            }
        },
        hideLogin: function () {
            $("#regist").hide().find("input").val(""); 
            $("#getCode").removeClass('disa').text('获取验证码')
            $("#otherPho").parent().removeClass('logined');
        },
        validate: function (len, t, msg, re) {
            var obj = $(t), val = obj.val(), err1 = "不正确", err2 = "请输入", result = true;
            if (val.length == 0) {
                Pub.msgTip(err2 + msg);
                result = false;
            } else if (val.length < len) {
                Pub.msgTip(msg + err1);
                result = false;
            } 
            if (!result) obj.focus(); 
            return result;
        },
        isLogin: function (fn) {
            if (!uInfo.mobile) {
                $("#regist").fadeIn();
            } else {
                fn();
            }
        },
        //p:参数,v:值
        setCookie: function (p, v) {
            $.cookie(p, v, { path: '/' });
        },
        setUrlParam: function (obj) {
            Pub.setCookie('urlP',JSON.stringify(obj));
        },
        getUrlParam: function () {
            return JSON.parse($.cookie('urlP'));
        },
        slidBanner: function (list, opt) { 
            var option = {
                isAutoplay: 1,
                isLooping: 1,
                isOverspread: 1,
                animateTime: 800,
                duration: 3000,
                fixPage: false, 
            }
            if (list.length > 1) {
                option = $.extend(option, { plugins: [['dot', { locate: 'relative' }]] })
            }
            option = $.extend(option,opt);
            var s = new iSlider(document.getElementById('banner'), list, option);
            return s;
        },
        //提交数据验证
        vali: function vali() {
            var msg = '', flag = true, vObj = $('.validate');
            for (var i = 0; i < vObj.length; i++) {
                var t = vObj.eq(i);
                if (!t.val()) {
                    msg = t.attr("placeholder");
                    flag = false;
                    break;
                }

            }
            return { msg: msg, flag: flag };
        }
    };
})(window);