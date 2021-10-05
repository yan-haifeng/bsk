(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["components/wuc-tab/wuc-tab"],{7626:function(t,n,e){"use strict";Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var u={name:"wuc-tab",data:function(){return{}},props:{tabList:{type:Array,default:function(){return[]}},tabCur:{type:Number,default:function(){return 0}},tabClass:{type:String,default:function(){return""}},tabStyle:{type:String,default:function(){return""}},textFlex:{type:Boolean,default:function(){return!1}},selectClass:{type:String,default:function(){return"text-blue"}}},methods:{tabSelect:function(t,n){if(this.currentTab===t)return!1;this.$emit("update:tabCur",t),this.$emit("change",t)}},computed:{scrollLeft:function(){return 60*(this.tabCur-1)}}};n.default=u},8264:function(t,n,e){"use strict";e.r(n);var u=e("7626"),r=e.n(u);for(var a in u)"default"!==a&&function(t){e.d(n,t,function(){return u[t]})}(a);n["default"]=r.a},cf31:function(t,n,e){"use strict";var u=function(){var t=this,n=t.$createElement;t._self._c},r=[];e.d(n,"a",function(){return u}),e.d(n,"b",function(){return r})},dba6:function(t,n,e){},df7b:function(t,n,e){"use strict";e.r(n);var u=e("cf31"),r=e("8264");for(var a in r)"default"!==a&&function(t){e.d(n,t,function(){return r[t]})}(a);e("f84b");var f=e("2877"),c=Object(f["a"])(r["default"],u["a"],u["b"],!1,null,null,null);n["default"]=c.exports},f84b:function(t,n,e){"use strict";var u=e("dba6"),r=e.n(u);r.a}}]);
;(global["webpackJsonp"] = global["webpackJsonp"] || []).push([
    'components/wuc-tab/wuc-tab-create-component',
    {
        'components/wuc-tab/wuc-tab-create-component':(function(module, exports, __webpack_require__){
            __webpack_require__('6e42')['createComponent'](__webpack_require__("df7b"))
        })
    },
    [['components/wuc-tab/wuc-tab-create-component']]
]);                
