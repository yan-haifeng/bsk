(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["components/uni-nav-bar1/uni-nav-bar1"],{"1f8d":function(t,n,e){},"72b9":function(t,n,e){"use strict";var i=e("1f8d"),u=e.n(i);u.a},"8be0":function(t,n,e){"use strict";var i=function(){var t=this,n=t.$createElement;t._self._c},u=[];e.d(n,"a",function(){return i}),e.d(n,"b",function(){return u})},cfa5:function(t,n,e){"use strict";e.r(n);var i=e("edc2"),u=e.n(i);for(var o in i)"default"!==o&&function(t){e.d(n,t,function(){return i[t]})}(o);n["default"]=u.a},edc2:function(t,n,e){"use strict";(function(t){Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var i=function(){return e.e("components/uni-status-bar/uni-status-bar").then(e.bind(null,"4613"))},u=function(){return Promise.all([e.e("common/vendor"),e.e("components/uni-icons/uni-icons")]).then(e.bind(null,"1d8b"))},o={name:"UniNavBar",components:{uniStatusBar:i,uniIcons:u},props:{title:{type:String,default:""},leftText:{type:String,default:""},rightText:{type:String,default:""},leftIcon:{type:String,default:""},rightIcon:{type:String,default:""},fixed:{type:[Boolean,String],default:!1},color:{type:String,default:"#000000"},backgroundColor:{type:String,default:"#FFFFFF"},statusBar:{type:[Boolean,String],default:!1},shadow:{type:[String,Boolean],default:!0},border:{type:[String,Boolean],default:!0}},mounted:function(){t.report&&""!==this.title&&t.report("title",this.title)},methods:{onClickLeft:function(){this.$emit("clickLeft")},onClickRight:function(){this.$emit("clickRight")}}};n.default=o}).call(this,e("6e42")["default"])},f9e3:function(t,n,e){"use strict";e.r(n);var i=e("8be0"),u=e("cfa5");for(var o in u)"default"!==o&&function(t){e.d(n,t,function(){return u[t]})}(o);e("72b9");var r=e("2877"),a=Object(r["a"])(u["default"],i["a"],i["b"],!1,null,"b7c5d9c4",null);n["default"]=a.exports}}]);
;(global["webpackJsonp"] = global["webpackJsonp"] || []).push([
    'components/uni-nav-bar1/uni-nav-bar1-create-component',
    {
        'components/uni-nav-bar1/uni-nav-bar1-create-component':(function(module, exports, __webpack_require__){
            __webpack_require__('6e42')['createComponent'](__webpack_require__("f9e3"))
        })
    },
    [['components/uni-nav-bar1/uni-nav-bar1-create-component']]
]);                
