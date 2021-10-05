package com.zime.bsk.entity;

import java.util.ArrayList;
import java.util.List;

public class CakeClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CakeClassExample() {
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

        public Criteria andCakeclassIdIsNull() {
            addCriterion("cakeclass_id is null");
            return (Criteria) this;
        }

        public Criteria andCakeclassIdIsNotNull() {
            addCriterion("cakeclass_id is not null");
            return (Criteria) this;
        }

        public Criteria andCakeclassIdEqualTo(Integer value) {
            addCriterion("cakeclass_id =", value, "cakeclassId");
            return (Criteria) this;
        }

        public Criteria andCakeclassIdNotEqualTo(Integer value) {
            addCriterion("cakeclass_id <>", value, "cakeclassId");
            return (Criteria) this;
        }

        public Criteria andCakeclassIdGreaterThan(Integer value) {
            addCriterion("cakeclass_id >", value, "cakeclassId");
            return (Criteria) this;
        }

        public Criteria andCakeclassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cakeclass_id >=", value, "cakeclassId");
            return (Criteria) this;
        }

        public Criteria andCakeclassIdLessThan(Integer value) {
            addCriterion("cakeclass_id <", value, "cakeclassId");
            return (Criteria) this;
        }

        public Criteria andCakeclassIdLessThanOrEqualTo(Integer value) {
            addCriterion("cakeclass_id <=", value, "cakeclassId");
            return (Criteria) this;
        }

        public Criteria andCakeclassIdIn(List<Integer> values) {
            addCriterion("cakeclass_id in", values, "cakeclassId");
            return (Criteria) this;
        }

        public Criteria andCakeclassIdNotIn(List<Integer> values) {
            addCriterion("cakeclass_id not in", values, "cakeclassId");
            return (Criteria) this;
        }

        public Criteria andCakeclassIdBetween(Integer value1, Integer value2) {
            addCriterion("cakeclass_id between", value1, value2, "cakeclassId");
            return (Criteria) this;
        }

        public Criteria andCakeclassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cakeclass_id not between", value1, value2, "cakeclassId");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameIsNull() {
            addCriterion("cakeclass_name is null");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameIsNotNull() {
            addCriterion("cakeclass_name is not null");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameEqualTo(String value) {
            addCriterion("cakeclass_name =", value, "cakeclassName");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameNotEqualTo(String value) {
            addCriterion("cakeclass_name <>", value, "cakeclassName");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameGreaterThan(String value) {
            addCriterion("cakeclass_name >", value, "cakeclassName");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameGreaterThanOrEqualTo(String value) {
            addCriterion("cakeclass_name >=", value, "cakeclassName");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameLessThan(String value) {
            addCriterion("cakeclass_name <", value, "cakeclassName");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameLessThanOrEqualTo(String value) {
            addCriterion("cakeclass_name <=", value, "cakeclassName");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameLike(String value) {
            addCriterion("cakeclass_name like", value, "cakeclassName");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameNotLike(String value) {
            addCriterion("cakeclass_name not like", value, "cakeclassName");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameIn(List<String> values) {
            addCriterion("cakeclass_name in", values, "cakeclassName");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameNotIn(List<String> values) {
            addCriterion("cakeclass_name not in", values, "cakeclassName");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameBetween(String value1, String value2) {
            addCriterion("cakeclass_name between", value1, value2, "cakeclassName");
            return (Criteria) this;
        }

        public Criteria andCakeclassNameNotBetween(String value1, String value2) {
            addCriterion("cakeclass_name not between", value1, value2, "cakeclassName");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoIsNull() {
            addCriterion("cakeclass_info is null");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoIsNotNull() {
            addCriterion("cakeclass_info is not null");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoEqualTo(String value) {
            addCriterion("cakeclass_info =", value, "cakeclassInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoNotEqualTo(String value) {
            addCriterion("cakeclass_info <>", value, "cakeclassInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoGreaterThan(String value) {
            addCriterion("cakeclass_info >", value, "cakeclassInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoGreaterThanOrEqualTo(String value) {
            addCriterion("cakeclass_info >=", value, "cakeclassInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoLessThan(String value) {
            addCriterion("cakeclass_info <", value, "cakeclassInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoLessThanOrEqualTo(String value) {
            addCriterion("cakeclass_info <=", value, "cakeclassInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoLike(String value) {
            addCriterion("cakeclass_info like", value, "cakeclassInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoNotLike(String value) {
            addCriterion("cakeclass_info not like", value, "cakeclassInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoIn(List<String> values) {
            addCriterion("cakeclass_info in", values, "cakeclassInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoNotIn(List<String> values) {
            addCriterion("cakeclass_info not in", values, "cakeclassInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoBetween(String value1, String value2) {
            addCriterion("cakeclass_info between", value1, value2, "cakeclassInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassInfoNotBetween(String value1, String value2) {
            addCriterion("cakeclass_info not between", value1, value2, "cakeclassInfo");
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