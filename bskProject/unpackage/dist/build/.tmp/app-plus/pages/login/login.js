(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/login/login"],{"00af":function(t,n,e){"use strict";e.r(n);var o=e("85de"),s=e.n(o);for(var i in o)"default"!==i&&function(t){e.d(n,t,function(){return o[t]})}(i);n["default"]=s.a},"132e":function(t,n,e){"use strict";e.r(n);var o=e("1c96"),s=e("00af");for(var i in s)"default"!==i&&function(t){e.d(n,t,function(){return s[t]})}(i);e("dbd0");var a=e("2877"),l=Object(a["a"])(s["default"],o["a"],o["b"],!1,null,null,null);n["default"]=l.exports},"1c96":function(t,n,e){"use strict";var o=function(){var t=this,n=t.$createElement;t._self._c},s=[];e.d(n,"a",function(){return o}),e.d(n,"b",function(){return s})},"7e72":function(t,n,e){"use strict";(function(t){e("5399"),e("921b");o(e("66fd"));var n=o(e("132e"));function o(t){return t&&t.__esModule?t:{default:t}}t(n.default)}).call(this,e("6e42")["createPage"])},"85de":function(t,n,e){"use strict";(function(t,o){Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var s=function(){return e.e("components/my-components/vcodebtn").then(e.bind(null,"6f5c"))},i={data:function(){return{isVcode:!1,isPwd:!0,content:"发送验证码",totalTime:10,canClick:!0,transformationBtnData:"手机号登录",username:"",verificationcode:"",password:""}},onLoad:function(){},methods:{toPwd:function(t){return this.isVcode?(this.isVcode=!1,this.isPwd=!0,this.transformationBtnData="手机号登录",null):this.isPwd?(this.isPwd=!1,this.isVcode=!0,this.transformationBtnData="密码登录",null):void 0},toReg:function(){t.navigateTo({url:"register"})},login:function(n){var e=this;return""==this.username||null==this.username?(t.showToast({icon:"none",title:"请输入手机号"}),null):this.isVcode?(console.log(o("这是验证码登录"," at pages\\login\\login.vue:83")),console.log(o(this.username+"/"+this.verificationcode," at pages\\login\\login.vue:84")),""==this.verificationcode||null==this.verificationcode?(t.showToast({icon:"none",title:"请输入验证码"}),null):(t.request({url:"http://www.reloss.top:8888/bsk/loginByPhone",data:{sessionid:this.$User.session,userPhone:this.username,code:this.verificationcode},success:function(n){console.log(o(n," at pages\\login\\login.vue:102")),1==n.data.code?t.showToast({title:n.data.msg,icon:"none"}):(e.$User.addUser(n.data.data[0]),e.$User.addSession(n.data.session),t.navigateBack({delta:1}))}}),null)):this.isPwd?(console.log(o("这是密码登录"," at pages\\login\\login.vue:124")),console.log(o(this.username+"/"+this.password," at pages\\login\\login.vue:125")),""==this.password||null==this.password?(t.showToast({icon:"none",title:"请输入密码"}),null):(t.request({url:"http://www.reloss.top:8888/bsk/loginByPwd",data:{userPhone:this.username,userPwd:this.password},success:function(n){console.log(o(n," at pages\\login\\login.vue:142")),1==n.data.code?t.showToast({title:n.data.msg,icon:"none"}):(e.$User.addUser(n.data.data[0]),e.$User.addSession(n.data.session),t.navigateBack({delta:1}))}}),null)):void 0}},components:{vcodebtn:s}};n.default=i}).call(this,e("6e42")["default"],e("0de9")["default"])},b5e2:function(t,n,e){},dbd0:function(t,n,e){"use strict";var o=e("b5e2"),s=e.n(o);s.a}},[["7e72","common/runtime","common/vendor"]]]);