(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/secondary/edit"],{"0b4e":function(e,t,a){"use strict";var i=function(){var e=this,t=e.$createElement;e._self._c},s=[];a.d(t,"a",function(){return i}),a.d(t,"b",function(){return s})},"4c61":function(e,t,a){"use strict";a.r(t);var i=a("98f0"),s=a.n(i);for(var n in i)"default"!==n&&function(e){a.d(t,e,function(){return i[e]})}(n);t["default"]=s.a},"4f1c":function(e,t,a){"use strict";(function(e){a("5399"),a("921b");i(a("66fd"));var t=i(a("f4b0"));function i(e){return e&&e.__esModule?e:{default:e}}e(t.default)}).call(this,a("6e42")["createPage"])},6789:function(e,t,a){"use strict";var i=a("df60"),s=a.n(i);s.a},"98f0":function(e,t,a){"use strict";(function(e,i){Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var s=function(){return Promise.all([a.e("common/vendor"),a.e("components/mpvue-citypicker/mpvueCityPicker")]).then(a.bind(null,"af84"))},n={components:{mpvueCityPicker:s},data:function(){return{editType:"edit",id:"",name:"",tel:"",detailed:"",isDefault:!1,themeColor:"#007AFF",cityPickerValue:"",httpDataUrl:this.$httpUrl.dataUrl,httpStaticUrl:this.$httpUrl.staticUrl}},methods:{onCancel:function(t){console.log(e(t," at pages\\secondary\\edit.vue:83"))},chooseCity:function(){this.$refs.mpvueCityPicker.show()},onConfirm:function(e){this.cityPickerValue=e.label},isDefaultChange:function(e){this.isDefault=e.detail.value},del:function(){var t=this;i.showModal({title:"删除提示",content:"你将删除这个收货地址",success:function(a){a.confirm?i.request({url:t.httpDataUrl+"/address/removeAddress?addressId="+t.id,success:function(e){0==e.data.code&&i.navigateBack()}}):a.cancel&&console.log(e("用户点击取消"," at pages\\secondary\\edit.vue:118"))}})},save:function(){var e={addressId:"",addressName:this.name,addressPhone:this.tel,addressInfo:this.cityPickerValue+"?"+this.detailed};"edit"==this.editType&&(e.addressId=this.id),e.addressName?e.addressPhone?e.addressInfo?(i.showLoading({title:"正在提交"}),"edit"==this.editType&&i.request({url:this.httpDataUrl+"/address/editAddress",data:e,success:function(e){0==e.data.code&&(i.hideLoading(),i.navigateBack())}}),"add"==this.editType&&(e.addressUserid=this.$User.user.userId,i.request({url:this.httpDataUrl+"/address/addAddress",data:e,success:function(e){0==e.data.code&&(i.hideLoading(),i.navigateBack())}}))):i.showToast({title:"请输入收件人详细地址",icon:"none"}):i.showToast({title:"请输入收件人电话号码",icon:"none"}):i.showToast({title:"请输入收件人姓名",icon:"none"})}},onLoad:function(e){var t=this;this.editType=e.type,"edit"==e.type&&i.getStorage({key:"address",success:function(e){t.id=e.data.addressId,t.name=e.data.addressName,t.tel=e.data.addressPhone,t.detailed=e.data.addressDetail,t.isDefault=e.data.isDefault,t.cityPickerValue=e.data.addressInfo}})},onBackPress:function(){if(this.$refs.mpvueCityPicker.showPicker)return this.$refs.mpvueCityPicker.pickerCancel(),!0},onUnload:function(){this.$refs.mpvueCityPicker.showPicker&&this.$refs.mpvueCityPicker.pickerCancel()}};t.default=n}).call(this,a("0de9")["default"],a("6e42")["default"])},df60:function(e,t,a){},f4b0:function(e,t,a){"use strict";a.r(t);var i=a("0b4e"),s=a("4c61");for(var n in s)"default"!==n&&function(e){a.d(t,e,function(){return s[e]})}(n);a("6789");var d=a("2877"),r=Object(d["a"])(s["default"],i["a"],i["b"],!1,null,null,null);t["default"]=r.exports}},[["4f1c","common/runtime","common/vendor"]]]);