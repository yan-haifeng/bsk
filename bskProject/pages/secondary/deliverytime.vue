<template>
	<view>
		<view class="contentBox">
			<calendar @tapDate="tapDate"></calendar>
			<view class="timeSlot">
				<view>选择时段：</view>
				<view class="timeBox">
					<button class="timeStyle" :class="{active:item.isSelect}" v-for="(item, index) in isTime" :key="index" @tap="clickTime(index)">{{item.time}}</button>
				</view>
			</view>
			<view class="deliveryTimeBox">
				<view>配送时间：</view>
				<view class="deliveryTime">{{curTimeDate+isTime[selectTime].time}}</view>
			</view>
		</view>
		<button class="determine" @tap="timeSubmit">确定</button>
	</view>
</template>

<script>
	import calendar from '@/components/my-components/zkw-calendar.vue'
	export default {
		data() {
			return {
				//可选时间段
				isTime:[
					{time:'09:00-12:00', isSelect:true},
					{time:'12:00-15:00', isSelect:false},
					{time:'15:00-18:00', isSelect:false},
					{time:'18:00-20:00', isSelect:false}
				],
				selectTime: 0,	//当选选中那个时间段下标
				curTimeDate:''	//选中的时间
				
			}
		},
		components:{
			calendar,
		},
		// onShow: {
		// 	// tapDate (data) {
		// 	// 	console.log(data)
		// 	// 	//this.curTime = 
		// 	// }
		// },
		onLoad(e) {
			let d = new Date()
			let y = d.getFullYear()
			let m = d.getMonth()
			m = m === 11 ? 12 : m+1 //月份转换
			let day = d.getDate()
			this.curTimeDate = `${m}月${day}日 `
		},
		methods: {
			tapDate (data) {
			//根据data.type进行判断用户点击的是哪一天,进行下一步业务操作
				//console.log(data)
				this.curTimeDate = data.month+"月"+data.date+"日 "
			},
			clickTime(data){
				//console.log(this.isTime)
				this.isTime[this.selectTime].isSelect = false
				this.selectTime = data
				this.isTime[data].isSelect = true
			},
			timeSubmit: function(){
				var pages = getCurrentPages();
				var prevPage = pages[pages.length - 2];
				//console.log(prevPage)
				// #ifndef H5
				prevPage.$vm.time = this.curTimeDate+this.isTime[this.selectTime].time;
				// #endif
				// #ifdef H5
				prevPage.time = this.curTimeDate+this.isTime[this.selectTime].time;
				// #endif
				uni.navigateBack({
					delta:1
				})
			}
		}
	}
</script>

<style>
.contentBox{
	margin: 30upx 20upx;
	border: 1px solid #DDDDDD;
	box-shadow: 1px 1px 5px #ddd;
}
.timeSlot{
	font-size: 28upx;
	margin: 20upx;
	padding: 10upx;
	border-top: 1px solid #FAFAFA;
	
}
.timeBox{
	width: 100%;
	overflow: hidden;
}
.timeBox .timeStyle{
	float: left;
	width: 30%;
	padding: 0;
	font-size: 24upx;
	color: #dddddd;
	background: #FFFFFF;
	border: 3upx solid #dddddd;
	margin-top: 20upx;
	margin-left: 30upx;
	box-sizing: border-box;
}
.timeBox .timeStyle::after{
	border: 0;
}
.timeBox .active{
	background: linear-gradient(90deg, #18EBF2, #3BC2C3);
	color: #FFFFFF;
}
.timeBox button:nth-child(3n+1){
	margin-left: 0upx;
}
.deliveryTimeBox{
	font-size: 28upx;
	margin: 20upx;
	margin-top: 40upx;
	padding: 10upx;
	border-top: 1px solid #FAFAFA;
	display: flex;
}
.deliveryTimeBox view{
	flex: 1;
}
.deliveryTime{
	text-align: right;
	color: #FF3765;
}
.determine{
	height: 100upx;
	line-height: 100upx;
	font-size: 40upx;
	color: #FFFFFF;
	margin: 40upx 80upx;
	border-radius: 5rem;
	background: linear-gradient(to right, #FE7196, #FF1850);
	box-shadow: 1px 3px 10px #bbbbbb;
}
</style>
