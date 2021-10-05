package com.zime.bsk.entity;

import java.util.ArrayList;
import java.util.List;

public class CakeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CakeInfoExample() {
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

        public Criteria andCakeIdIsNull() {
            addCriterion("cake_id is null");
            return (Criteria) this;
        }

        public Criteria andCakeIdIsNotNull() {
            addCriterion("cake_id is not null");
            return (Criteria) this;
        }

        public Criteria andCakeIdEqualTo(Integer value) {
            addCriterion("cake_id =", value, "cakeId");
            return (Criteria) this;
        }

        public Criteria andCakeIdNotEqualTo(Integer value) {
            addCriterion("cake_id <>", value, "cakeId");
            return (Criteria) this;
        }

        public Criteria andCakeIdGreaterThan(Integer value) {
            addCriterion("cake_id >", value, "cakeId");
            return (Criteria) this;
        }

        public Criteria andCakeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cake_id >=", value, "cakeId");
            return (Criteria) this;
        }

        public Criteria andCakeIdLessThan(Integer value) {
            addCriterion("cake_id <", value, "cakeId");
            return (Criteria) this;
        }

        public Criteria andCakeIdLessThanOrEqualTo(Integer value) {
            addCriterion("cake_id <=", value, "cakeId");
            return (Criteria) this;
        }

        public Criteria andCakeIdIn(List<Integer> values) {
            addCriterion("cake_id in", values, "cakeId");
            return (Criteria) this;
        }

        public Criteria andCakeIdNotIn(List<Integer> values) {
            addCriterion("cake_id not in", values, "cakeId");
            return (Criteria) this;
        }

        public Criteria andCakeIdBetween(Integer value1, Integer value2) {
            addCriterion("cake_id between", value1, value2, "cakeId");
            return (Criteria) this;
        }

        public Criteria andCakeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cake_id not between", value1, value2, "cakeId");
            return (Criteria) this;
        }

        public Criteria andCakeNameIsNull() {
            addCriterion("cake_name is null");
            return (Criteria) this;
        }

        public Criteria andCakeNameIsNotNull() {
            addCriterion("cake_name is not null");
            return (Criteria) this;
        }

        public Criteria andCakeNameEqualTo(String value) {
            addCriterion("cake_name =", value, "cakeName");
            return (Criteria) this;
        }

        public Criteria andCakeNameNotEqualTo(String value) {
            addCriterion("cake_name <>", value, "cakeName");
            return (Criteria) this;
        }

        public Criteria andCakeNameGreaterThan(String value) {
            addCriterion("cake_name >", value, "cakeName");
            return (Criteria) this;
        }

        public Criteria andCakeNameGreaterThanOrEqualTo(String value) {
            addCriterion("cake_name >=", value, "cakeName");
            return (Criteria) this;
        }

        public Criteria andCakeNameLessThan(String value) {
            addCriterion("cake_name <", value, "cakeName");
            return (Criteria) this;
        }

        public Criteria andCakeNameLessThanOrEqualTo(String value) {
            addCriterion("cake_name <=", value, "cakeName");
            return (Criteria) this;
        }

        public Criteria andCakeNameLike(String value) {
            addCriterion("cake_name like", value, "cakeName");
            return (Criteria) this;
        }

        public Criteria andCakeNameNotLike(String value) {
            addCriterion("cake_name not like", value, "cakeName");
            return (Criteria) this;
        }

        public Criteria andCakeNameIn(List<String> values) {
            addCriterion("cake_name in", values, "cakeName");
            return (Criteria) this;
        }

        public Criteria andCakeNameNotIn(List<String> values) {
            addCriterion("cake_name not in", values, "cakeName");
            return (Criteria) this;
        }

        public Criteria andCakeNameBetween(String value1, String value2) {
            addCriterion("cake_name between", value1, value2, "cakeName");
            return (Criteria) this;
        }

        public Criteria andCakeNameNotBetween(String value1, String value2) {
            addCriterion("cake_name not between", value1, value2, "cakeName");
            return (Criteria) this;
        }

        public Criteria andCakeEnameIsNull() {
            addCriterion("cake_ename is null");
            return (Criteria) this;
        }

        public Criteria andCakeEnameIsNotNull() {
            addCriterion("cake_ename is not null");
            return (Criteria) this;
        }

        public Criteria andCakeEnameEqualTo(String value) {
            addCriterion("cake_ename =", value, "cakeEname");
            return (Criteria) this;
        }

        public Criteria andCakeEnameNotEqualTo(String value) {
            addCriterion("cake_ename <>", value, "cakeEname");
            return (Criteria) this;
        }

        public Criteria andCakeEnameGreaterThan(String value) {
            addCriterion("cake_ename >", value, "cakeEname");
            return (Criteria) this;
        }

        public Criteria andCakeEnameGreaterThanOrEqualTo(String value) {
            addCriterion("cake_ename >=", value, "cakeEname");
            return (Criteria) this;
        }

        public Criteria andCakeEnameLessThan(String value) {
            addCriterion("cake_ename <", value, "cakeEname");
            return (Criteria) this;
        }

        public Criteria andCakeEnameLessThanOrEqualTo(String value) {
            addCriterion("cake_ename <=", value, "cakeEname");
            return (Criteria) this;
        }

        public Criteria andCakeEnameLike(String value) {
            addCriterion("cake_ename like", value, "cakeEname");
            return (Criteria) this;
        }

        public Criteria andCakeEnameNotLike(String value) {
            addCriterion("cake_ename not like", value, "cakeEname");
            return (Criteria) this;
        }

        public Criteria andCakeEnameIn(List<String> values) {
            addCriterion("cake_ename in", values, "cakeEname");
            return (Criteria) this;
        }

        public Criteria andCakeEnameNotIn(List<String> values) {
            addCriterion("cake_ename not in", values, "cakeEname");
            return (Criteria) this;
        }

        public Criteria andCakeEnameBetween(String value1, String value2) {
            addCriterion("cake_ename between", value1, value2, "cakeEname");
            return (Criteria) this;
        }

        public Criteria andCakeEnameNotBetween(String value1, String value2) {
            addCriterion("cake_ename not between", value1, value2, "cakeEname");
            return (Criteria) this;
        }

        public Criteria andCakeImgIsNull() {
            addCriterion("cake_img is null");
            return (Criteria) this;
        }

        public Criteria andCakeImgIsNotNull() {
            addCriterion("cake_img is not null");
            return (Criteria) this;
        }

        public Criteria andCakeImgEqualTo(String value) {
            addCriterion("cake_img =", value, "cakeImg");
            return (Criteria) this;
        }

        public Criteria andCakeImgNotEqualTo(String value) {
            addCriterion("cake_img <>", value, "cakeImg");
            return (Criteria) this;
        }

        public Criteria andCakeImgGreaterThan(String value) {
            addCriterion("cake_img >", value, "cakeImg");
            return (Criteria) this;
        }

        public Criteria andCakeImgGreaterThanOrEqualTo(String value) {
            addCriterion("cake_img >=", value, "cakeImg");
            return (Criteria) this;
        }

        public Criteria andCakeImgLessThan(String value) {
            addCriterion("cake_img <", value, "cakeImg");
            return (Criteria) this;
        }

        public Criteria andCakeImgLessThanOrEqualTo(String value) {
            addCriterion("cake_img <=", value, "cakeImg");
            return (Criteria) this;
        }

        public Criteria andCakeImgLike(String value) {
            addCriterion("cake_img like", value, "cakeImg");
            return (Criteria) this;
        }

        public Criteria andCakeImgNotLike(String value) {
            addCriterion("cake_img not like", value, "cakeImg");
            return (Criteria) this;
        }

        public Criteria andCakeImgIn(List<String> values) {
            addCriterion("cake_img in", values, "cakeImg");
            return (Criteria) this;
        }

        public Criteria andCakeImgNotIn(List<String> values) {
            addCriterion("cake_img not in", values, "cakeImg");
            return (Criteria) this;
        }

        public Criteria andCakeImgBetween(String value1, String value2) {
            addCriterion("cake_img between", value1, value2, "cakeImg");
            return (Criteria) this;
        }

        public Criteria andCakeImgNotBetween(String value1, String value2) {
            addCriterion("cake_img not between", value1, value2, "cakeImg");
            return (Criteria) this;
        }

        public Criteria andCakeClassidIsNull() {
            addCriterion("cake_classid is null");
            return (Criteria) this;
        }

        public Criteria andCakeClassidIsNotNull() {
            addCriterion("cake_classid is not null");
            return (Criteria) this;
        }

        public Criteria andCakeClassidEqualTo(Integer value) {
            addCriterion("cake_classid =", value, "cakeClassid");
            return (Criteria) this;
        }

        public Criteria andCakeClassidNotEqualTo(Integer value) {
            addCriterion("cake_classid <>", value, "cakeClassid");
            return (Criteria) this;
        }

        public Criteria andCakeClassidGreaterThan(Integer value) {
            addCriterion("cake_classid >", value, "cakeClassid");
            return (Criteria) this;
        }

        public Criteria andCakeClassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cake_classid >=", value, "cakeClassid");
            return (Criteria) this;
        }

        public Criteria andCakeClassidLessThan(Integer value) {
            addCriterion("cake_classid <", value, "cakeClassid");
            return (Criteria) this;
        }

        public Criteria andCakeClassidLessThanOrEqualTo(Integer value) {
            addCriterion("cake_classid <=", value, "cakeClassid");
            return (Criteria) this;
        }

        public Criteria andCakeClassidIn(List<Integer> values) {
            addCriterion("cake_classid in", values, "cakeClassid");
            return (Criteria) this;
        }

        public Criteria andCakeClassidNotIn(List<Integer> values) {
            addCriterion("cake_classid not in", values, "cakeClassid");
            return (Criteria) this;
        }

        public Criteria andCakeClassidBetween(Integer value1, Integer value2) {
            addCriterion("cake_classid between", value1, value2, "cakeClassid");
            return (Criteria) this;
        }

        public Criteria andCakeClassidNotBetween(Integer value1, Integer value2) {
            addCriterion("cake_classid not between", value1, value2, "cakeClassid");
            return (Criteria) this;
        }

        public Criteria andCakeClassminidIsNull() {
            addCriterion("cake_classminid is null");
            return (Criteria) this;
        }

        public Criteria andCakeClassminidIsNotNull() {
            addCriterion("cake_classminid is not null");
            return (Criteria) this;
        }

        public Criteria andCakeClassminidEqualTo(Integer value) {
            addCriterion("cake_classminid =", value, "cakeClassminid");
            return (Criteria) this;
        }

        public Criteria andCakeClassminidNotEqualTo(Integer value) {
            addCriterion("cake_classminid <>", value, "cakeClassminid");
            return (Criteria) this;
        }

        public Criteria andCakeClassminidGreaterThan(Integer value) {
            addCriterion("cake_classminid >", value, "cakeClassminid");
            return (Criteria) this;
        }

        public Criteria andCakeClassminidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cake_classminid >=", value, "cakeClassminid");
            return (Criteria) this;
        }

        public Criteria andCakeClassminidLessThan(Integer value) {
            addCriterion("cake_classminid <", value, "cakeClassminid");
            return (Criteria) this;
        }

        public Criteria andCakeClassminidLessThanOrEqualTo(Integer value) {
            addCriterion("cake_classminid <=", value, "cakeClassminid");
            return (Criteria) this;
        }

        public Criteria andCakeClassminidIn(List<Integer> values) {
            addCriterion("cake_classminid in", values, "cakeClassminid");
            return (Criteria) this;
        }

        public Criteria andCakeClassminidNotIn(List<Integer> values) {
            addCriterion("cake_classminid not in", values, "cakeClassminid");
            return (Criteria) this;
        }

        public Criteria andCakeClassminidBetween(Integer value1, Integer value2) {
            addCriterion("cake_classminid between", value1, value2, "cakeClassminid");
            return (Criteria) this;
        }

        public Criteria andCakeClassminidNotBetween(Integer value1, Integer value2) {
            addCriterion("cake_classminid not between", value1, value2, "cakeClassminid");
            return (Criteria) this;
        }

        public Criteria andCakeSpecsidIsNull() {
            addCriterion("cake_specsid is null");
            return (Criteria) this;
        }

        public Criteria andCakeSpecsidIsNotNull() {
            addCriterion("cake_specsid is not null");
            return (Criteria) this;
        }

        public Criteria andCakeSpecsidEqualTo(Integer value) {
            addCriterion("cake_specsid =", value, "cakeSpecsid");
            return (Criteria) this;
        }

        public Criteria andCakeSpecsidNotEqualTo(Integer value) {
            addCriterion("cake_specsid <>", value, "cakeSpecsid");
            return (Criteria) this;
        }

        public Criteria andCakeSpecsidGreaterThan(Integer value) {
            addCriterion("cake_specsid >", value, "cakeSpecsid");
            return (Criteria) this;
        }

        public Criteria andCakeSpecsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cake_specsid >=", value, "cakeSpecsid");
            return (Criteria) this;
        }

        public Criteria andCakeSpecsidLessThan(Integer value) {
            addCriterion("cake_specsid <", value, "cakeSpecsid");
            return (Criteria) this;
        }

        public Criteria andCakeSpecsidLessThanOrEqualTo(Integer value) {
            addCriterion("cake_specsid <=", value, "cakeSpecsid");
            return (Criteria) this;
        }

        public Criteria andCakeSpecsidIn(List<Integer> values) {
            addCriterion("cake_specsid in", values, "cakeSpecsid");
            return (Criteria) this;
        }

        public Criteria andCakeSpecsidNotIn(List<Integer> values) {
            addCriterion("cake_specsid not in", values, "cakeSpecsid");
            return (Criteria) this;
        }

        public Criteria andCakeSpecsidBetween(Integer value1, Integer value2) {
            addCriterion("cake_specsid between", value1, value2, "cakeSpecsid");
            return (Criteria) this;
        }

        public Criteria andCakeSpecsidNotBetween(Integer value1, Integer value2) {
            addCriterion("cake_specsid not between", value1, value2, "cakeSpecsid");
            return (Criteria) this;
        }

        public Criteria andCakeNumIsNull() {
            addCriterion("cake_num is null");
            return (Criteria) this;
        }

        public Criteria andCakeNumIsNotNull() {
            addCriterion("cake_num is not null");
            return (Criteria) this;
        }

        public Criteria andCakeNumEqualTo(Integer value) {
            addCriterion("cake_num =", value, "cakeNum");
            return (Criteria) this;
        }

        public Criteria andCakeNumNotEqualTo(Integer value) {
            addCriterion("cake_num <>", value, "cakeNum");
            return (Criteria) this;
        }

        public Criteria andCakeNumGreaterThan(Integer value) {
            addCriterion("cake_num >", value, "cakeNum");
            return (Criteria) this;
        }

        public Criteria andCakeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cake_num >=", value, "cakeNum");
            return (Criteria) this;
        }

        public Criteria andCakeNumLessThan(Integer value) {
            addCriterion("cake_num <", value, "cakeNum");
            return (Criteria) this;
        }

        public Criteria andCakeNumLessThanOrEqualTo(Integer value) {
            addCriterion("cake_num <=", value, "cakeNum");
            return (Criteria) this;
        }

        public Criteria andCakeNumIn(List<Integer> values) {
            addCriterion("cake_num in", values, "cakeNum");
            return (Criteria) this;
        }

        public Criteria andCakeNumNotIn(List<Integer> values) {
            addCriterion("cake_num not in", values, "cakeNum");
            return (Criteria) this;
        }

        public Criteria andCakeNumBetween(Integer value1, Integer value2) {
            addCriterion("cake_num between", value1, value2, "cakeNum");
            return (Criteria) this;
        }

        public Criteria andCakeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("cake_num not between", value1, value2, "cakeNum");
            return (Criteria) this;
        }

        public Criteria andCakeInfoIsNull() {
            addCriterion("cake_info is null");
            return (Criteria) this;
        }

        public Criteria andCakeInfoIsNotNull() {
            addCriterion("cake_info is not null");
            return (Criteria) this;
        }

        public Criteria andCakeInfoEqualTo(String value) {
            addCriterion("cake_info =", value, "cakeInfo");
            return (Criteria) this;
        }

        public Criteria andCakeInfoNotEqualTo(String value) {
            addCriterion("cake_info <>", value, "cakeInfo");
            return (Criteria) this;
        }

        public Criteria andCakeInfoGreaterThan(String value) {
            addCriterion("cake_info >", value, "cakeInfo");
            return (Criteria) this;
        }

        public Criteria andCakeInfoGreaterThanOrEqualTo(String value) {
            addCriterion("cake_info >=", value, "cakeInfo");
            return (Criteria) this;
        }

        public Criteria andCakeInfoLessThan(String value) {
            addCriterion("cake_info <", value, "cakeInfo");
            return (Criteria) this;
        }

        public Criteria andCakeInfoLessThanOrEqualTo(String value) {
            addCriterion("cake_info <=", value, "cakeInfo");
            return (Criteria) this;
        }

        public Criteria andCakeInfoLike(String value) {
            addCriterion("cake_info like", value, "cakeInfo");
            return (Criteria) this;
        }

        public Criteria andCakeInfoNotLike(String value) {
            addCriterion("cake_info not like", value, "cakeInfo");
            return (Criteria) this;
        }

        public Criteria andCakeInfoIn(List<String> values) {
            addCriterion("cake_info in", values, "cakeInfo");
            return (Criteria) this;
        }

        public Criteria andCakeInfoNotIn(List<String> values) {
            addCriterion("cake_info not in", values, "cakeInfo");
            return (Criteria) this;
        }

        public Criteria andCakeInfoBetween(String value1, String value2) {
            addCriterion("cake_info between", value1, value2, "cakeInfo");
            return (Criteria) this;
        }

        public Criteria andCakeInfoNotBetween(String value1, String value2) {
            addCriterion("cake_info not between", value1, value2, "cakeInfo");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountIsNull() {
            addCriterion("cake_discount is null");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountIsNotNull() {
            addCriterion("cake_discount is not null");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountEqualTo(Double value) {
            addCriterion("cake_discount =", value, "cakeDiscount");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountNotEqualTo(Double value) {
            addCriterion("cake_discount <>", value, "cakeDiscount");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountGreaterThan(Double value) {
            addCriterion("cake_discount >", value, "cakeDiscount");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("cake_discount >=", value, "cakeDiscount");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountLessThan(Double value) {
            addCriterion("cake_discount <", value, "cakeDiscount");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountLessThanOrEqualTo(Double value) {
            addCriterion("cake_discount <=", value, "cakeDiscount");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountIn(List<Double> values) {
            addCriterion("cake_discount in", values, "cakeDiscount");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountNotIn(List<Double> values) {
            addCriterion("cake_discount not in", values, "cakeDiscount");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountBetween(Double value1, Double value2) {
            addCriterion("cake_discount between", value1, value2, "cakeDiscount");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountNotBetween(Double value1, Double value2) {
            addCriterion("cake_discount not between", value1, value2, "cakeDiscount");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountdayIsNull() {
            addCriterion("cake_discountday is null");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountdayIsNotNull() {
            addCriterion("cake_discountday is not null");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountdayEqualTo(Integer value) {
            addCriterion("cake_discountday =", value, "cakeDiscountday");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountdayNotEqualTo(Integer value) {
            addCriterion("cake_discountday <>", value, "cakeDiscountday");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountdayGreaterThan(Integer value) {
            addCriterion("cake_discountday >", value, "cakeDiscountday");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("cake_discountday >=", value, "cakeDiscountday");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountdayLessThan(Integer value) {
            addCriterion("cake_discountday <", value, "cakeDiscountday");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountdayLessThanOrEqualTo(Integer value) {
            addCriterion("cake_discountday <=", value, "cakeDiscountday");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountdayIn(List<Integer> values) {
            addCriterion("cake_discountday in", values, "cakeDiscountday");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountdayNotIn(List<Integer> values) {
            addCriterion("cake_discountday not in", values, "cakeDiscountday");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountdayBetween(Integer value1, Integer value2) {
            addCriterion("cake_discountday between", value1, value2, "cakeDiscountday");
            return (Criteria) this;
        }

        public Criteria andCakeDiscountdayNotBetween(Integer value1, Integer value2) {
            addCriterion("cake_discountday not between", value1, value2, "cakeDiscountday");
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