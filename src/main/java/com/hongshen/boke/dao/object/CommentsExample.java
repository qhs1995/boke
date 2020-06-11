package com.hongshen.boke.dao.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentsExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTouristIdIsNull() {
            addCriterion("tourist_id is null");
            return (Criteria) this;
        }

        public Criteria andTouristIdIsNotNull() {
            addCriterion("tourist_id is not null");
            return (Criteria) this;
        }

        public Criteria andTouristIdEqualTo(Integer value) {
            addCriterion("tourist_id =", value, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdNotEqualTo(Integer value) {
            addCriterion("tourist_id <>", value, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdGreaterThan(Integer value) {
            addCriterion("tourist_id >", value, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tourist_id >=", value, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdLessThan(Integer value) {
            addCriterion("tourist_id <", value, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdLessThanOrEqualTo(Integer value) {
            addCriterion("tourist_id <=", value, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdIn(List<Integer> values) {
            addCriterion("tourist_id in", values, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdNotIn(List<Integer> values) {
            addCriterion("tourist_id not in", values, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdBetween(Integer value1, Integer value2) {
            addCriterion("tourist_id between", value1, value2, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tourist_id not between", value1, value2, "touristId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsIsNull() {
            addCriterion("leave_comments is null");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsIsNotNull() {
            addCriterion("leave_comments is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsEqualTo(String value) {
            addCriterion("leave_comments =", value, "leaveComments");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsNotEqualTo(String value) {
            addCriterion("leave_comments <>", value, "leaveComments");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsGreaterThan(String value) {
            addCriterion("leave_comments >", value, "leaveComments");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("leave_comments >=", value, "leaveComments");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsLessThan(String value) {
            addCriterion("leave_comments <", value, "leaveComments");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsLessThanOrEqualTo(String value) {
            addCriterion("leave_comments <=", value, "leaveComments");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsLike(String value) {
            addCriterion("leave_comments like", value, "leaveComments");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsNotLike(String value) {
            addCriterion("leave_comments not like", value, "leaveComments");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsIn(List<String> values) {
            addCriterion("leave_comments in", values, "leaveComments");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsNotIn(List<String> values) {
            addCriterion("leave_comments not in", values, "leaveComments");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsBetween(String value1, String value2) {
            addCriterion("leave_comments between", value1, value2, "leaveComments");
            return (Criteria) this;
        }

        public Criteria andLeaveCommentsNotBetween(String value1, String value2) {
            addCriterion("leave_comments not between", value1, value2, "leaveComments");
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