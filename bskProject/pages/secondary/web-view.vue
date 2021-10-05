<!-- 浏览器打开 -->
<template>
	<view class="advertisement" style="width: 100%;">
		<web-view :src="'http://www.reloss.top:8888/bsk/alipay/payPhone?'+data" @message="message"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				httpDataUrl: this.$httpUrl.dataUrl,
				url: '/alipay/pay',
				// orderId: 0,
				// orderNo: "",
				// orderCarid: "",
				// orderUserid: 0,
				// orderTime: "",
				// orderPrice: 0,
				// orderDiscount: 0,
				// orderType: 0,
				// orderAddressid: 0,
				// orderDeliverytime: "",
				// orderCarriage: "",
				// orderState: ""
				data:""
			};
		},
		onLoad(data) { //这里对要传入到webview中的参数进行encodeURIComponent编码否则中文乱码
			// this.url+=encodeURIComponent(data.data)
			console.log(this.$Order.order)
			// data = "orderId=" + this.$Order.order.orderId + "&orderNo" + this.$Order.order.orderNo + "&orderNo" + this.$Order.order.orderNo+ "&orderNo" + this.$Order.order.orderNo+ "&orderNo" + this.$Order.order.orderNo
			// this.orderId = this.$Order.order.orderId
			// this.orderNo = this.$Order.order.orderNo
			// this.orderCarid = this.$Order.order.orderCarid
			// this.orderUserid = this.$Order.order.orderUserid
			// this.orderTime = this.$Order.order.orderTime
			// this.orderPrice = this.$Order.order.orderPrice
			// this.orderDiscount = this.$Order.order.orderDiscount
			// this.orderType = this.$Order.order.orderType
			// this.orderAddressid = this.$Order.order.orderAddressid
			// this.orderDeliverytime = this.$Order.order.orderDeliverytime
			// this.orderCarriage = this.$Order.order.orderCarriage
			// this.orderState = this.$Order.order.orderStat
			this.$Order.order.orderTime = null
			this.$Order.order.orderDeliverytime = null
			this.data = this.urlEncode(this.$Order.order).slice(1)
			//console.log(this.urlEncode(this.$Order.order).slice(1))
		},
		mounted() {},
		methods: {
			message(event) {
				console.log(event.detail.data);
			},
			urlEncode: function(param, key, encode) {
				if (param == null) return '';
				var paramStr = '';
				var t = typeof(param);
				if (t == 'string' || t == 'number' || t == 'boolean') {
					paramStr += '&' + key + '=' + ((encode == null || encode) ? encodeURIComponent(param) : param);
				} else {
					for (var i in param) {
						var k = key == null ? i : key + (param instanceof Array ? '[' + i + ']' : '.' + i)
						paramStr += this.urlEncode(param[i], k, encode)
					}
				}
				return paramStr;
			}
		}
	};
</script>
<style>
</style>
