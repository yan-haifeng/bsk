package com.zime.bsk.entity;

import java.util.ArrayList;
import java.util.List;

public class CakeCarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CakeCarExample() {
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarUseridIsNull() {
            addCriterion("car_userid is null");
            return (Criteria) this;
        }

        public Criteria andCarUseridIsNotNull() {
            addCriterion("car_userid is not null");
            return (Criteria) this;
        }

        public Criteria andCarUseridEqualTo(Integer value) {
            addCriterion("car_userid =", value, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridNotEqualTo(Integer value) {
            addCriterion("car_userid <>", value, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridGreaterThan(Integer value) {
            addCriterion("car_userid >", value, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_userid >=", value, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridLessThan(Integer value) {
            addCriterion("car_userid <", value, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridLessThanOrEqualTo(Integer value) {
            addCriterion("car_userid <=", value, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridIn(List<Integer> values) {
            addCriterion("car_userid in", values, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridNotIn(List<Integer> values) {
            addCriterion("car_userid not in", values, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridBetween(Integer value1, Integer value2) {
            addCriterion("car_userid between", value1, value2, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("car_userid not between", value1, value2, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarCakeidIsNull() {
            addCriterion("car_cakeid is null");
            return (Criteria) this;
        }

        public Criteria andCarCakeidIsNotNull() {
            addCriterion("car_cakeid is not null");
            return (Criteria) this;
        }

        public Criteria andCarCakeidEqualTo(Integer value) {
            addCriterion("car_cakeid =", value, "carCakeid");
            return (Criteria) this;
        }

        public Criteria andCarCakeidNotEqualTo(Integer value) {
            addCriterion("car_cakeid <>", value, "carCakeid");
            return (Criteria) this;
        }

        public Criteria andCarCakeidGreaterThan(Integer value) {
            addCriterion("car_cakeid >", value, "carCakeid");
            return (Criteria) this;
        }

        public Criteria andCarCakeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_cakeid >=", value, "carCakeid");
            return (Criteria) this;
        }

        public Criteria andCarCakeidLessThan(Integer value) {
            addCriterion("car_cakeid <", value, "carCakeid");
            return (Criteria) this;
        }

        public Criteria andCarCakeidLessThanOrEqualTo(Integer value) {
            addCriterion("car_cakeid <=", value, "carCakeid");
            return (Criteria) this;
        }

        public Criteria andCarCakeidIn(List<Integer> values) {
            addCriterion("car_cakeid in", values, "carCakeid");
            return (Criteria) this;
        }

        public Criteria andCarCakeidNotIn(List<Integer> values) {
            addCriterion("car_cakeid not in", values, "carCakeid");
            return (Criteria) this;
        }

        public Criteria andCarCakeidBetween(Integer value1, Integer value2) {
            addCriterion("car_cakeid between", value1, value2, "carCakeid");
            return (Criteria) this;
        }

        public Criteria andCarCakeidNotBetween(Integer value1, Integer value2) {
            addCriterion("car_cakeid not between", value1, value2, "carCakeid");
            return (Criteria) this;
        }

        public Criteria andCarSpecsidIsNull() {
            addCriterion("car_specsid is null");
            return (Criteria) this;
        }

        public Criteria andCarSpecsidIsNotNull() {
            addCriterion("car_specsid is not null");
            return (Criteria) this;
        }

        public Criteria andCarSpecsidEqualTo(Integer value) {
            addCriterion("car_specsid =", value, "carSpecsid");
            return (Criteria) this;
        }

        public Criteria andCarSpecsidNotEqualTo(Integer value) {
            addCriterion("car_specsid <>", value, "carSpecsid");
            return (Criteria) this;
        }

        public Criteria andCarSpecsidGreaterThan(Integer value) {
            addCriterion("car_specsid >", value, "carSpecsid");
            return (Criteria) this;
        }

        public Criteria andCarSpecsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_specsid >=", value, "carSpecsid");
            return (Criteria) this;
        }

        public Criteria andCarSpecsidLessThan(Integer value) {
            addCriterion("car_specsid <", value, "carSpecsid");
            return (Criteria) this;
        }

        public Criteria andCarSpecsidLessThanOrEqualTo(Integer value) {
            addCriterion("car_specsid <=", value, "carSpecsid");
            return (Criteria) this;
        }

        public Criteria andCarSpecsidIn(List<Integer> values) {
            addCriterion("car_specsid in", values, "carSpecsid");
            return (Criteria) this;
        }

        public Criteria andCarSpecsidNotIn(List<Integer> values) {
            addCriterion("car_specsid not in", values, "carSpecsid");
            return (Criteria) this;
        }

        public Criteria andCarSpecsidBetween(Integer value1, Integer value2) {
            addCriterion("car_specsid between", value1, value2, "carSpecsid");
            return (Criteria) this;
        }

        public Criteria andCarSpecsidNotBetween(Integer value1, Integer value2) {
            addCriterion("car_specsid not between", value1, value2, "carSpecsid");
            return (Criteria) this;
        }

        public Criteria andCarNumIsNull() {
            addCriterion("car_num is null");
            return (Criteria) this;
        }

        public Criteria andCarNumIsNotNull() {
            addCriterion("car_num is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumEqualTo(Integer value) {
            addCriterion("car_num =", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotEqualTo(Integer value) {
            addCriterion("car_num <>", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumGreaterThan(Integer value) {
            addCriterion("car_num >", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_num >=", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumLessThan(Integer value) {
            addCriterion("car_num <", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumLessThanOrEqualTo(Integer value) {
            addCriterion("car_num <=", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumIn(List<Integer> values) {
            addCriterion("car_num in", values, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotIn(List<Integer> values) {
            addCriterion("car_num not in", values, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumBetween(Integer value1, Integer value2) {
            addCriterion("car_num between", value1, value2, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotBetween(Integer value1, Integer value2) {
            addCriterion("car_num not between", value1, value2, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarStateIsNull() {
            addCriterion("car_state is null");
            return (Criteria) this;
        }

        public Criteria andCarStateIsNotNull() {
            addCriterion("car_state is not null");
            return (Criteria) this;
        }

        public Criteria andCarStateEqualTo(Integer value) {
            addCriterion("car_state =", value, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateNotEqualTo(Integer value) {
            addCriterion("car_state <>", value, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateGreaterThan(Integer value) {
            addCriterion("car_state >", value, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_state >=", value, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateLessThan(Integer value) {
            addCriterion("car_state <", value, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateLessThanOrEqualTo(Integer value) {
            addCriterion("car_state <=", value, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateIn(List<Integer> values) {
            addCriterion("car_state in", values, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateNotIn(List<Integer> values) {
            addCriterion("car_state not in", values, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateBetween(Integer value1, Integer value2) {
            addCriterion("car_state between", value1, value2, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateNotBetween(Integer value1, Integer value2) {
            addCriterion("car_state not between", value1, value2, "carState");
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