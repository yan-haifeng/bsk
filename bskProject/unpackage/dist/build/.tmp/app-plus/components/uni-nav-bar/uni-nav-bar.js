(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["components/uni-nav-bar/uni-nav-bar"],{"07f2":function(t,n,e){"use strict";e.r(n);var u=e("bf77"),i=e("4d6f");for(var o in i)"default"!==o&&function(t){e.d(n,t,function(){return i[t]})}(o);e("cc53");var a=e("2877"),r=Object(a["a"])(i["default"],u["a"],u["b"],!1,null,"41a71e6a",null);n["default"]=r.exports},"4d6f":function(t,n,e){"use strict";e.r(n);var u=e("8d62"),i=e.n(u);for(var o in u)"default"!==o&&function(t){e.d(n,t,function(){return u[t]})}(o);n["default"]=i.a},"674a":function(t,n,e){},"8d62":function(t,n,e){"use strict";(function(t){Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var u=function(){return e.e("components/uni-status-bar/uni-status-bar").then(e.bind(null,"4613"))},i=function(){return Promise.all([e.e("common/vendor"),e.e("components/uni-icons/uni-icons")]).then(e.bind(null,"1d8b"))},o={name:"UniNavBar",components:{uniStatusBar:u,uniIcons:i},props:{title:{type:String,default:""},leftText:{type:String,default:""},rightText:{type:String,default:""},leftIcon:{type:String,default:""},rightIcon:{type:String,default:""},fixed:{type:[Boolean,String],default:!1},color:{type:String,default:"#000000"},backgroundColor:{type:String,default:"#FFFFFF"},statusBar:{type:[Boolean,String],default:!1},shadow:{type:[String,Boolean],default:!1},border:{type:[String,Boolean],default:!0},borderTop:{type:String,default:""},paddingTop:{type:String,default:"20px"},background:{type:String,default:""},statusHeight:{type:Number,default:20}},mounted:function(){t.report&&""!==this.title&&t.report("title",this.title)},methods:{onClickLeft:function(){this.$emit("clickLeft")},onClickRight:function(){this.$emit("clickRight")},upxToPx:function(n){return t.upx2px(n)}}};n.default=o}).call(this,e("6e42")["default"])},bf77:function(t,n,e){"use strict";var u=function(){var t=this,n=t.$createElement,e=(t._self._c,t.upxToPx(88));t.$mp.data=Object.assign({},{$root:{m0:e}})},i=[];e.d(n,"a",function(){return u}),e.d(n,"b",function(){return i})},cc53:function(t,n,e){"use strict";var u=e("674a"),i=e.n(u);i.a}}]);
;(global["webpackJsonp"] = global["webpackJsonp"] || []).push([
    'components/uni-nav-bar/uni-nav-bar-create-component',
    {
        'components/uni-nav-bar/uni-nav-bar-create-component':(function(module, exports, __webpack_require__){
            __webpack_require__('6e42')['createComponent'](__webpack_require__("07f2"))
        })
    },
    [['components/uni-nav-bar/uni-nav-bar-create-component']]
]);                
