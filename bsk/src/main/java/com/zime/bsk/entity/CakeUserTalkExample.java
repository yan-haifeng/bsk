package com.zime.bsk.entity;

import java.util.ArrayList;
import java.util.List;

public class CakeUserTalkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CakeUserTalkExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTalkIdIsNull() {
            addCriterion("talk_id is null");
            return (Criteria) this;
        }

        public Criteria andTalkIdIsNotNull() {
            addCriterion("talk_id is not null");
            return (Criteria) this;
        }

        public Criteria andTalkIdEqualTo(Integer value) {
            addCriterion("talk_id =", value, "talkId");
            return (Criteria) this;
        }

        public Criteria andTalkIdNotEqualTo(Integer value) {
            addCriterion("talk_id <>", value, "talkId");
            return (Criteria) this;
        }

        public Criteria andTalkIdGreaterThan(Integer value) {
            addCriterion("talk_id >", value, "talkId");
            return (Criteria) this;
        }

        public Criteria andTalkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("talk_id >=", value, "talkId");
            return (Criteria) this;
        }

        public Criteria andTalkIdLessThan(Integer value) {
            addCriterion("talk_id <", value, "talkId");
            return (Criteria) this;
        }

        public Criteria andTalkIdLessThanOrEqualTo(Integer value) {
            addCriterion("talk_id <=", value, "talkId");
            return (Criteria) this;
        }

        public Criteria andTalkIdIn(List<Integer> values) {
            addCriterion("talk_id in", values, "talkId");
            return (Criteria) this;
        }

        public Criteria andTalkIdNotIn(List<Integer> values) {
            addCriterion("talk_id not in", values, "talkId");
            return (Criteria) this;
        }

        public Criteria andTalkIdBetween(Integer value1, Integer value2) {
            addCriterion("talk_id between", value1, value2, "talkId");
            return (Criteria) this;
        }

        public Criteria andTalkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("talk_id not between", value1, value2, "talkId");
            return (Criteria) this;
        }

        public Criteria andTalkUseridIsNull() {
            addCriterion("talk_userid is null");
            return (Criteria) this;
        }

        public Criteria andTalkUseridIsNotNull() {
            addCriterion("talk_userid is not null");
            return (Criteria) this;
        }

        public Criteria andTalkUseridEqualTo(Integer value) {
            addCriterion("talk_userid =", value, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridNotEqualTo(Integer value) {
            addCriterion("talk_userid <>", value, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridGreaterThan(Integer value) {
            addCriterion("talk_userid >", value, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("talk_userid >=", value, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridLessThan(Integer value) {
            addCriterion("talk_userid <", value, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridLessThanOrEqualTo(Integer value) {
            addCriterion("talk_userid <=", value, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridIn(List<Integer> values) {
            addCriterion("talk_userid in", values, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridNotIn(List<Integer> values) {
            addCriterion("talk_userid not in", values, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridBetween(Integer value1, Integer value2) {
            addCriterion("talk_userid between", value1, value2, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("talk_userid not between", value1, value2, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkCakeidIsNull() {
            addCriterion("talk_cakeid is null");
            return (Criteria) this;
        }

        public Criteria andTalkCakeidIsNotNull() {
            addCriterion("talk_cakeid is not null");
            return (Criteria) this;
        }

        public Criteria andTalkCakeidEqualTo(Integer value) {
            addCriterion("talk_cakeid =", value, "talkCakeid");
            return (Criteria) this;
        }

        public Criteria andTalkCakeidNotEqualTo(Integer value) {
            addCriterion("talk_cakeid <>", value, "talkCakeid");
            return (Criteria) this;
        }

        public Criteria andTalkCakeidGreaterThan(Integer value) {
            addCriterion("talk_cakeid >", value, "talkCakeid");
            return (Criteria) this;
        }

        public Criteria andTalkCakeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("talk_cakeid >=", value, "talkCakeid");
            return (Criteria) this;
        }

        public Criteria andTalkCakeidLessThan(Integer value) {
            addCriterion("talk_cakeid <", value, "talkCakeid");
            return (Criteria) this;
        }

        public Criteria andTalkCakeidLessThanOrEqualTo(Integer value) {
            addCriterion("talk_cakeid <=", value, "talkCakeid");
            return (Criteria) this;
        }

        public Criteria andTalkCakeidIn(List<Integer> values) {
            addCriterion("talk_cakeid in", values, "talkCakeid");
            return (Criteria) this;
        }

        public Criteria andTalkCakeidNotIn(List<Integer> values) {
            addCriterion("talk_cakeid not in", values, "talkCakeid");
            return (Criteria) this;
        }

        public Criteria andTalkCakeidBetween(Integer value1, Integer value2) {
            addCriterion("talk_cakeid between", value1, value2, "talkCakeid");
            return (Criteria) this;
        }

        public Criteria andTalkCakeidNotBetween(Integer value1, Integer value2) {
            addCriterion("talk_cakeid not between", value1, value2, "talkCakeid");
            return (Criteria) this;
        }

        public Criteria andTalkCommoditygradeIsNull() {
            addCriterion("talk_commoditygrade is null");
            return (Criteria) this;
        }

        public Criteria andTalkCommoditygradeIsNotNull() {
            addCriterion("talk_commoditygrade is not null");
            return (Criteria) this;
        }

        public Criteria andTalkCommoditygradeEqualTo(Integer value) {
            addCriterion("talk_commoditygrade =", value, "talkCommoditygrade");
            return (Criteria) this;
        }

        public Criteria andTalkCommoditygradeNotEqualTo(Integer value) {
            addCriterion("talk_commoditygrade <>", value, "talkCommoditygrade");
            return (Criteria) this;
        }

        public Criteria andTalkCommoditygradeGreaterThan(Integer value) {
            addCriterion("talk_commoditygrade >", value, "talkCommoditygrade");
            return (Criteria) this;
        }

        public Criteria andTalkCommoditygradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("talk_commoditygrade >=", value, "talkCommoditygrade");
            return (Criteria) this;
        }

        public Criteria andTalkCommoditygradeLessThan(Integer value) {
            addCriterion("talk_commoditygrade <", value, "talkCommoditygrade");
            return (Criteria) this;
        }

        public Criteria andTalkCommoditygradeLessThanOrEqualTo(Integer value) {
            addCriterion("talk_commoditygrade <=", value, "talkCommoditygrade");
            return (Criteria) this;
        }

        public Criteria andTalkCommoditygradeIn(List<Integer> values) {
            addCriterion("talk_commoditygrade in", values, "talkCommoditygrade");
            return (Criteria) this;
        }

        public Criteria andTalkCommoditygradeNotIn(List<Integer> values) {
            addCriterion("talk_commoditygrade not in", values, "talkCommoditygrade");
            return (Criteria) this;
        }

        public Criteria andTalkCommoditygradeBetween(Integer value1, Integer value2) {
            addCriterion("talk_commoditygrade between", value1, value2, "talkCommoditygrade");
            return (Criteria) this;
        }

        public Criteria andTalkCommoditygradeNotBetween(Integer value1, Integer value2) {
            addCriterion("talk_commoditygrade not between", value1, value2, "talkCommoditygrade");
            return (Criteria) this;
        }

        public Criteria andTalkLogisticsgradeIsNull() {
            addCriterion("talk_logisticsgrade is null");
            return (Criteria) this;
        }

        public Criteria andTalkLogisticsgradeIsNotNull() {
            addCriterion("talk_logisticsgrade is not null");
            return (Criteria) this;
        }

        public Criteria andTalkLogisticsgradeEqualTo(Integer value) {
            addCriterion("talk_logisticsgrade =", value, "talkLogisticsgrade");
            return (Criteria) this;
        }

        public Criteria andTalkLogisticsgradeNotEqualTo(Integer value) {
            addCriterion("talk_logisticsgrade <>", value, "talkLogisticsgrade");
            return (Criteria) this;
        }

        public Criteria andTalkLogisticsgradeGreaterThan(Integer value) {
            addCriterion("talk_logisticsgrade >", value, "talkLogisticsgrade");
            return (Criteria) this;
        }

        public Criteria andTalkLogisticsgradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("talk_logisticsgrade >=", value, "talkLogisticsgrade");
            return (Criteria) this;
        }

        public Criteria andTalkLogisticsgradeLessThan(Integer value) {
            addCriterion("talk_logisticsgrade <", value, "talkLogisticsgrade");
            return (Criteria) this;
        }

        public Criteria andTalkLogisticsgradeLessThanOrEqualTo(Integer value) {
            addCriterion("talk_logisticsgrade <=", value, "talkLogisticsgrade");
            return (Criteria) this;
        }

        public Criteria andTalkLogisticsgradeIn(List<Integer> values) {
            addCriterion("talk_logisticsgrade in", values, "talkLogisticsgrade");
            return (Criteria) this;
        }

        public Criteria andTalkLogisticsgradeNotIn(List<Integer> values) {
            addCriterion("talk_logisticsgrade not in", values, "talkLogisticsgrade");
            return (Criteria) this;
        }

        public Criteria andTalkLogisticsgradeBetween(Integer value1, Integer value2) {
            addCriterion("talk_logisticsgrade between", value1, value2, "talkLogisticsgrade");
            return (Criteria) this;
        }

        public Criteria andTalkLogisticsgradeNotBetween(Integer value1, Integer value2) {
            addCriterion("talk_logisticsgrade not between", value1, value2, "talkLogisticsgrade");
            return (Criteria) this;
        }

        public Criteria andTalkServicegradeIsNull() {
            addCriterion("talk_servicegrade is null");
            return (Criteria) this;
        }

        public Criteria andTalkServicegradeIsNotNull() {
            addCriterion("talk_servicegrade is not null");
            return (Criteria) this;
        }

        public Criteria andTalkServicegradeEqualTo(Integer value) {
            addCriterion("talk_servicegrade =", value, "talkServicegrade");
            return (Criteria) this;
        }

        public Criteria andTalkServicegradeNotEqualTo(Integer value) {
            addCriterion("talk_servicegrade <>", value, "talkServicegrade");
            return (Criteria) this;
        }

        public Criteria andTalkServicegradeGreaterThan(Integer value) {
            addCriterion("talk_servicegrade >", value, "talkServicegrade");
            return (Criteria) this;
        }

        public Criteria andTalkServicegradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("talk_servicegrade >=", value, "talkServicegrade");
            return (Criteria) this;
        }

        public Criteria andTalkServicegradeLessThan(Integer value) {
            addCriterion("talk_servicegrade <", value, "talkServicegrade");
            return (Criteria) this;
        }

        public Criteria andTalkServicegradeLessThanOrEqualTo(Integer value) {
            addCriterion("talk_servicegrade <=", value, "talkServicegrade");
            return (Criteria) this;
        }

        public Criteria andTalkServicegradeIn(List<Integer> values) {
            addCriterion("talk_servicegrade in", values, "talkServicegrade");
            return (Criteria) this;
        }

        public Criteria andTalkServicegradeNotIn(List<Integer> values) {
            addCriterion("talk_servicegrade not in", values, "talkServicegrade");
            return (Criteria) this;
        }

        public Criteria andTalkServicegradeBetween(Integer value1, Integer value2) {
            addCriterion("talk_servicegrade between", value1, value2, "talkServicegrade");
            return (Criteria) this;
        }

        public Criteria andTalkServicegradeNotBetween(Integer value1, Integer value2) {
            addCriterion("talk_servicegrade not between", value1, value2, "talkServicegrade");
            return (Criteria) this;
        }

        public Criteria andTalkIsimgIsNull() {
            addCriterion("talk_isimg is null");
            return (Criteria) this;
        }

        public Criteria andTalkIsimgIsNotNull() {
            addCriterion("talk_isimg is not null");
            return (Criteria) this;
        }

        public Criteria andTalkIsimgEqualTo(Integer value) {
            addCriterion("talk_isimg =", value, "talkIsimg");
            return (Criteria) this;
        }

        public Criteria andTalkIsimgNotEqualTo(Integer value) {
            addCriterion("talk_isimg <>", value, "talkIsimg");
            return (Criteria) this;
        }

        public Criteria andTalkIsimgGreaterThan(Integer value) {
            addCriterion("talk_isimg >", value, "talkIsimg");
            return (Criteria) this;
        }

        public Criteria andTalkIsimgGreaterThanOrEqualTo(Integer value) {
            addCriterion("talk_isimg >=", value, "talkIsimg");
            return (Criteria) this;
        }

        public Criteria andTalkIsimgLessThan(Integer value) {
            addCriterion("talk_isimg <", value, "talkIsimg");
            return (Criteria) this;
        }

        public Criteria andTalkIsimgLessThanOrEqualTo(Integer value) {
            addCriterion("talk_isimg <=", value, "talkIsimg");
            return (Criteria) this;
        }

        public Criteria andTalkIsimgIn(List<Integer> values) {
            addCriterion("talk_isimg in", values, "talkIsimg");
            return (Criteria) this;
        }

        public Criteria andTalkIsimgNotIn(List<Integer> values) {
            addCriterion("talk_isimg not in", values, "talkIsimg");
            return (Criteria) this;
        }

        public Criteria andTalkIsimgBetween(Integer value1, Integer value2) {
            addCriterion("talk_isimg between", value1, value2, "talkIsimg");
            return (Criteria) this;
        }

        public Criteria andTalkIsimgNotBetween(Integer value1, Integer value2) {
            addCriterion("talk_isimg not between", value1, value2, "talkIsimg");
            return (Criteria) this;
        }

        public Criteria andTalkImgIsNull() {
            addCriterion("talk_img is null");
            return (Criteria) this;
        }

        public Criteria andTalkImgIsNotNull() {
            addCriterion("talk_img is not null");
            return (Criteria) this;
        }

        public Criteria andTalkImgEqualTo(String value) {
            addCriterion("talk_img =", value, "talkImg");
            return (Criteria) this;
        }

        public Criteria andTalkImgNotEqualTo(String value) {
            addCriterion("talk_img <>", value, "talkImg");
            return (Criteria) this;
        }

        public Criteria andTalkImgGreaterThan(String value) {
            addCriterion("talk_img >", value, "talkImg");
            return (Criteria) this;
        }

        public Criteria andTalkImgGreaterThanOrEqualTo(String value) {
            addCriterion("talk_img >=", value, "talkImg");
            return (Criteria) this;
        }

        public Criteria andTalkImgLessThan(String value) {
            addCriterion("talk_img <", value, "talkImg");
            return (Criteria) this;
        }

        public Criteria andTalkImgLessThanOrEqualTo(String value) {
            addCriterion("talk_img <=", value, "talkImg");
            return (Criteria) this;
        }

        public Criteria andTalkImgLike(String value) {
            addCriterion("talk_img like", value, "talkImg");
            return (Criteria) this;
        }

        public Criteria andTalkImgNotLike(String value) {
            addCriterion("talk_img not like", value, "talkImg");
            return (Criteria) this;
        }

        public Criteria andTalkImgIn(List<String> values) {
            addCriterion("talk_img in", values, "talkImg");
            return (Criteria) this;
        }

        public Criteria andTalkImgNotIn(List<String> values) {
            addCriterion("talk_img not in", values, "talkImg");
            return (Criteria) this;
        }

        public Criteria andTalkImgBetween(String value1, String value2) {
            addCriterion("talk_img between", value1, value2, "talkImg");
            return (Criteria) this;
        }

        public Criteria andTalkImgNotBetween(String value1, String value2) {
            addCriterion("talk_img not between", value1, value2, "talkImg");
            return (Criteria) this;
        }

        public Criteria andTalkInfoIsNull() {
            addCriterion("talk_info is null");
            return (Criteria) this;
        }

        public Criteria andTalkInfoIsNotNull() {
            addCriterion("talk_info is not null");
            return (Criteria) this;
        }

        public Criteria andTalkInfoEqualTo(String value) {
            addCriterion("talk_info =", value, "talkInfo");
            return (Criteria) this;
        }

        public Criteria andTalkInfoNotEqualTo(String value) {
            addCriterion("talk_info <>", value, "talkInfo");
            return (Criteria) this;
        }

        public Criteria andTalkInfoGreaterThan(String value) {
            addCriterion("talk_info >", value, "talkInfo");
            return (Criteria) this;
        }

        public Criteria andTalkInfoGreaterThanOrEqualTo(String value) {
            addCriterion("talk_info >=", value, "talkInfo");
            return (Criteria) this;
        }

        public Criteria andTalkInfoLessThan(String value) {
            addCriterion("talk_info <", value, "talkInfo");
            return (Criteria) this;
        }

        public Criteria andTalkInfoLessThanOrEqualTo(String value) {
            addCriterion("talk_info <=", value, "talkInfo");
            return (Criteria) this;
        }

        public Criteria andTalkInfoLike(String value) {
            addCriterion("talk_info like", value, "talkInfo");
            return (Criteria) this;
        }

        public Criteria andTalkInfoNotLike(String value) {
            addCriterion("talk_info not like", value, "talkInfo");
            return (Criteria) this;
        }

        public Criteria andTalkInfoIn(List<String> values) {
            addCriterion("talk_info in", values, "talkInfo");
            return (Criteria) this;
        }

        public Criteria andTalkInfoNotIn(List<String> values) {
            addCriterion("talk_info not in", values, "talkInfo");
            return (Criteria) this;
        }

        public Criteria andTalkInfoBetween(String value1, String value2) {
            addCriterion("talk_info between", value1, value2, "talkInfo");
            return (Criteria) this;
        }

        public Criteria andTalkInfoNotBetween(String value1, String value2) {
            addCriterion("talk_info not between", value1, value2, "talkInfo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}