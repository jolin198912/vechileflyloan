package cn.houhe.api.facade;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.houhe.api.config.entity.DistributionConfig;
import cn.houhe.api.config.entity.Level;
import cn.houhe.api.config.service.DistributionConfigService;
import cn.houhe.api.config.service.LevelService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by think on 2017/4/28.
 */
@Service
public class ConfigFacade {

    private static Logger logger = LoggerFactory.getLogger(ConfigFacade.class);

    @Autowired
    private LevelService levelService;

    @Autowired
    private DistributionConfigService distributionConfigService;
    /**
     * 获得信用等级
     * @param totalScores
     * @return
     */
    public int getCreditLevel(int loanType, Integer totalScores) {

        if (loanType == 0){
            List<Level> levels = levelService.findAll(Criteria.create(Level.class)
            .add(ExpressionFactory.lessEqual("minScore",totalScores))
            .add(ExpressionFactory.greaterEqual("maxScore",totalScores)));
            if (CollectionUtils.isNotEmpty(levels)){
                return levels.get(0).getLevelId();
            }
        }else {
            List<Level> levels = levelService.findAll(Criteria.create(Level.class)
                    .add(ExpressionFactory.lessEqual("installmentMinScore",totalScores))
                    .add(ExpressionFactory.greaterEqual("installmentMaxScore",totalScores)));
            if (CollectionUtils.isNotEmpty(levels)){
                return levels.get(0).getLevelId();
            }
        }
        return 0;
    }

    /**
     * 判断额度
     * @param loanType
     * @param scores
     * @return
     */
    public int judgeLoanLimit(Integer loanType, Integer scores) {
        int levelId = getCreditLevel(loanType,scores);
        Level level =  levelService.findByPrimaryKey((short) levelId);
        if (level == null){
            return 0;
        }
        BigDecimal limit = new BigDecimal(0);
        if (loanType == 0){

            limit =level.getMinLimit() .add( level.getMaxLimit() .subtract(level.getMinLimit()).divide(new BigDecimal(level.getMaxScore() - level.getMinScore()),BigDecimal.ROUND_FLOOR).multiply(new BigDecimal(scores - level.getMinScore())));
        }else {
            limit = level.getInstallmentMinLimit() .add( level.getInstallmentMaxLimit() .subtract(level.getInstallmentMinLimit()).divide(level.getInstallmentMaxScore().subtract( level.getInstallmentMinScore()),BigDecimal.ROUND_FLOOR).multiply(new BigDecimal(scores - level.getInstallmentMinScore().intValue())));
        }
        int l = (int) Math.floor(limit.doubleValue());
        return l - l % 100;
    }

    /**
     * 判断是否能自动审批通过
     * @param score 评分
     * @return true 是
     */
    public boolean canAutoCredit( int score) {
        List<DistributionConfig> configs =   distributionConfigService.findAll(Criteria.create(DistributionConfig.class)
        .add(ExpressionFactory.eq("type",0))
                .add(ExpressionFactory.lessEqual("minScore",score))
        .add(ExpressionFactory.greaterEqual("maxScore",score)));
        return CollectionUtils.isNotEmpty(configs);
    }
}
