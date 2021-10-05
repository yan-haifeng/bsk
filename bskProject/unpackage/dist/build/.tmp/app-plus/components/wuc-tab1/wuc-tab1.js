(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["components/wuc-tab1/wuc-tab1"],{"162a":function(t,n,e){"use strict";Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var u={name:"wuc-tab",data:function(){return{}},props:{tabList:{type:Array,default:function(){return[]}},tabCur:{type:Number,default:function(){return 0}},tabClass:{type:String,default:function(){return""}},tabStyle:{type:String,default:function(){return""}},textFlex:{type:Boolean,default:function(){return!1}},selectClass:{type:String,default:function(){return"text-blue"}}},methods:{tabSelect:function(t,n){if(this.currentTab===t)return!1;this.$emit("update:tabCur",t),this.$emit("change",t)}},computed:{scrollLeft:function(){return 60*(this.tabCur-1)}}};n.default=u},"47c3":function(t,n,e){"use strict";e.r(n);var u=e("b85e"),r=e("63d9");for(var a in r)"default"!==a&&function(t){e.d(n,t,function(){return r[t]})}(a);e("b8dd");var c=e("2877"),f=Object(c["a"])(r["default"],u["a"],u["b"],!1,null,null,null);n["default"]=f.exports},"63d9":function(t,n,e){"use strict";e.r(n);var u=e("162a"),r=e.n(u);for(var a in u)"default"!==a&&function(t){e.d(n,t,function(){return u[t]})}(a);n["default"]=r.a},b85e:function(t,n,e){"use strict";var u=function(){var t=this,n=t.$createElement;t._self._c},r=[];e.d(n,"a",function(){return u}),e.d(n,"b",function(){return r})},b8dd:function(t,n,e){"use strict";var u=e("f7cc"),r=e.n(u);r.a},f7cc:function(t,n,e){}}]);
;(global["webpackJsonp"] = global["webpackJsonp"] || []).push([
    'components/wuc-tab1/wuc-tab1-create-component',
    {
        'components/wuc-tab1/wuc-tab1-create-component':(function(module, exports, __webpack_require__){
            __webpack_require__('6e42')['createComponent'](__webpack_require__("47c3"))
        })
    },
    [['components/wuc-tab1/wuc-tab1-create-component']]
]);                
