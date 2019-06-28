package com.tester.mybatis.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransfercaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransfercaseExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParamjsonIsNull() {
            addCriterion("paramJson is null");
            return (Criteria) this;
        }

        public Criteria andParamjsonIsNotNull() {
            addCriterion("paramJson is not null");
            return (Criteria) this;
        }

        public Criteria andParamjsonEqualTo(String value) {
            addCriterion("paramJson =", value, "paramjson");
            return (Criteria) this;
        }

        public Criteria andParamjsonNotEqualTo(String value) {
            addCriterion("paramJson <>", value, "paramjson");
            return (Criteria) this;
        }

        public Criteria andParamjsonGreaterThan(String value) {
            addCriterion("paramJson >", value, "paramjson");
            return (Criteria) this;
        }

        public Criteria andParamjsonGreaterThanOrEqualTo(String value) {
            addCriterion("paramJson >=", value, "paramjson");
            return (Criteria) this;
        }

        public Criteria andParamjsonLessThan(String value) {
            addCriterion("paramJson <", value, "paramjson");
            return (Criteria) this;
        }

        public Criteria andParamjsonLessThanOrEqualTo(String value) {
            addCriterion("paramJson <=", value, "paramjson");
            return (Criteria) this;
        }

        public Criteria andParamjsonLike(String value) {
            addCriterion("paramJson like", value, "paramjson");
            return (Criteria) this;
        }

        public Criteria andParamjsonNotLike(String value) {
            addCriterion("paramJson not like", value, "paramjson");
            return (Criteria) this;
        }

        public Criteria andParamjsonIn(List<String> values) {
            addCriterion("paramJson in", values, "paramjson");
            return (Criteria) this;
        }

        public Criteria andParamjsonNotIn(List<String> values) {
            addCriterion("paramJson not in", values, "paramjson");
            return (Criteria) this;
        }

        public Criteria andParamjsonBetween(String value1, String value2) {
            addCriterion("paramJson between", value1, value2, "paramjson");
            return (Criteria) this;
        }

        public Criteria andParamjsonNotBetween(String value1, String value2) {
            addCriterion("paramJson not between", value1, value2, "paramjson");
            return (Criteria) this;
        }

        public Criteria andResultjsonIsNull() {
            addCriterion("resultJson is null");
            return (Criteria) this;
        }

        public Criteria andResultjsonIsNotNull() {
            addCriterion("resultJson is not null");
            return (Criteria) this;
        }

        public Criteria andResultjsonEqualTo(String value) {
            addCriterion("resultJson =", value, "resultjson");
            return (Criteria) this;
        }

        public Criteria andResultjsonNotEqualTo(String value) {
            addCriterion("resultJson <>", value, "resultjson");
            return (Criteria) this;
        }

        public Criteria andResultjsonGreaterThan(String value) {
            addCriterion("resultJson >", value, "resultjson");
            return (Criteria) this;
        }

        public Criteria andResultjsonGreaterThanOrEqualTo(String value) {
            addCriterion("resultJson >=", value, "resultjson");
            return (Criteria) this;
        }

        public Criteria andResultjsonLessThan(String value) {
            addCriterion("resultJson <", value, "resultjson");
            return (Criteria) this;
        }

        public Criteria andResultjsonLessThanOrEqualTo(String value) {
            addCriterion("resultJson <=", value, "resultjson");
            return (Criteria) this;
        }

        public Criteria andResultjsonLike(String value) {
            addCriterion("resultJson like", value, "resultjson");
            return (Criteria) this;
        }

        public Criteria andResultjsonNotLike(String value) {
            addCriterion("resultJson not like", value, "resultjson");
            return (Criteria) this;
        }

        public Criteria andResultjsonIn(List<String> values) {
            addCriterion("resultJson in", values, "resultjson");
            return (Criteria) this;
        }

        public Criteria andResultjsonNotIn(List<String> values) {
            addCriterion("resultJson not in", values, "resultjson");
            return (Criteria) this;
        }

        public Criteria andResultjsonBetween(String value1, String value2) {
            addCriterion("resultJson between", value1, value2, "resultjson");
            return (Criteria) this;
        }

        public Criteria andResultjsonNotBetween(String value1, String value2) {
            addCriterion("resultJson not between", value1, value2, "resultjson");
            return (Criteria) this;
        }

        public Criteria andExceptIsNull() {
            addCriterion("except is null");
            return (Criteria) this;
        }

        public Criteria andExceptIsNotNull() {
            addCriterion("except is not null");
            return (Criteria) this;
        }

        public Criteria andExceptEqualTo(String value) {
            addCriterion("except =", value, "except");
            return (Criteria) this;
        }

        public Criteria andExceptNotEqualTo(String value) {
            addCriterion("except <>", value, "except");
            return (Criteria) this;
        }

        public Criteria andExceptGreaterThan(String value) {
            addCriterion("except >", value, "except");
            return (Criteria) this;
        }

        public Criteria andExceptGreaterThanOrEqualTo(String value) {
            addCriterion("except >=", value, "except");
            return (Criteria) this;
        }

        public Criteria andExceptLessThan(String value) {
            addCriterion("except <", value, "except");
            return (Criteria) this;
        }

        public Criteria andExceptLessThanOrEqualTo(String value) {
            addCriterion("except <=", value, "except");
            return (Criteria) this;
        }

        public Criteria andExceptLike(String value) {
            addCriterion("except like", value, "except");
            return (Criteria) this;
        }

        public Criteria andExceptNotLike(String value) {
            addCriterion("except not like", value, "except");
            return (Criteria) this;
        }

        public Criteria andExceptIn(List<String> values) {
            addCriterion("except in", values, "except");
            return (Criteria) this;
        }

        public Criteria andExceptNotIn(List<String> values) {
            addCriterion("except not in", values, "except");
            return (Criteria) this;
        }

        public Criteria andExceptBetween(String value1, String value2) {
            addCriterion("except between", value1, value2, "except");
            return (Criteria) this;
        }

        public Criteria andExceptNotBetween(String value1, String value2) {
            addCriterion("except not between", value1, value2, "except");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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