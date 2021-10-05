<template>
	<view class="sign-wrap">
		<view class="date-wrap">
			<view class="cur-date">
				<div class="nowBefore" @tap="beforeMonth()">
					←
				</div> <div class="nowDate">
						{{curDate}}
				</div>
				<div class="nowAfter" @tap="afterMonth()">
					→
				</div>
			</view>
			<view class="title-item-box item-box">
				<view class="item item-textColor" v-for="(item, index) in ['日','一','二','三','四','五','六']" :key="index">{{item}}
				</view>
			</view>
			<view class="date-item-box item-box">
				<view class="item date-item" :class="{disabled:item.disabled,active:item.isToday}" :style="itemStyle" @tap="tapThis(item)"
				 v-for="(item, index) in dateArray" :key="index">
					{{item.date}}
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				nextMonthTemp: 0, //记录月份加多少在点击日期左右时
				beforeDay: 0, //记录1号前有几天空着
				itemStyle: '',
				curDate: '', //选中日期
				curDay: 0, //当前选中时哪天
				dateArray: []
			}
		},
		methods: {
			getCurDate(nextMonthTemp) {
				this.dateArray = []
				let nextMonth = 0
				nextMonth = nextMonthTemp
				let d = new Date()
				//console.log(d)
				let mE = d.toDateString().split(" ")[1]
				//console.log(mE)
				let y = d.getFullYear()
				let m = d.getMonth()
				let day = d.getDate()
				d = new Date(y, m + nextMonth, day)
				y = d.getFullYear()
				m = d.getMonth()
				day = d.getDate()
				let week = new Date(y, m, 1).getDay() //一号是周几
				this.beforeDay = week
				//console.log(new Date(y, m, 0))
				m = m === 11 ? 12 : m + 1 //月份转换
				let max = new Date(y, m, 0).getDate() //本月最大天
				this.curDay = day
				this.curDate = `${m}月 ${y}`
				// 1号之前留白,对应正确的周几
				for (let i = 0; i < week; i++) {
					let obj = {
						year: '',
						month: '',
						monthE: '',
						date: '',
						disabled: false,
						isToday: false
					}
					this.dateArray.push(obj)
				}
				for (let i = 0; i < max; i++) {
					let today = i + 1
					let obj = {
						year: y,
						month: m,
						monthE: mE,
						date: today,
						disabled: today < day,
						isToday: today == day
					}
					this.dateArray.push(obj)
				}
			},
			//点击日期
			tapThis(e) {
				if (!e.date) return
				const data = {
					year: e.year,
					month: e.month,
					date: e.date,
					//type :'today' //默认点击今天
				};
				//点击今天之前
				//(e.disabled && !e.isToday) && (data.type = 'pre');
				//点击今天之后
				//(!e.disabled && !e.isToday) && (data.type = 'next');
				//console.log(e)
				//修改点击样式
				this.dateArray[e.date + this.beforeDay - 1].disabled = false
				this.dateArray[e.date + this.beforeDay - 1].isToday = true
				//修改上一个选中样式
				this.dateArray[this.curDay + this.beforeDay - 1].disabled = true
				this.dateArray[this.curDay + this.beforeDay - 1].isToday = false
				this.curDay = e.date
				this.$emit('tapDate', data)
			},
			beforeMonth(e) {
				//console.log(e)
				this.nextMonthTemp--
				this.getCurDate(this.nextMonthTemp)
			},
			afterMonth() {
				this.nextMonthTemp++
				this.getCurDate(this.nextMonthTemp)
			}
		},
		mounted() {
			//设置天数高度
			let nodes = uni.createSelectorQuery().in(this).select('.item')
			nodes.fields({
				size: true,
			}, data => {
				this.itemStyle =
					`height:${data.width}px;line-height:${data.width}px;margin: 10upx calc((100% - ${data.width*7}px) / 14);`
			}).exec();

			//设置日期
			this.getCurDate(this.nextMonthTemp)
		}
	}
</script>

<style scoped lang="scss">
	.date-wrap {
		width: 96%;
		margin-left: 2%;
		padding: 2% 0;
		border-radius: 16upx;
		background: #fff;
		box-sizing: border-box;
		text-align: center;

		.cur-date {
			height: 50upx;
			line-height: 50upx;
			font-weight: bold;
			font-size: 30upx;
			display: flex;
			flex-direction: row;
		}

		.cur-date .nowAfter {
			flex: 1;
		}

		.cur-date .nowDate {
			flex: 1;
		}

		.cur-date .nowBefore {
			flex: 1;
		}

		.item-textColor {
			color: #FF2157;
			font-weight: bold;
		}

		.item-box {
			display: flex;
			color: #777;
			flex-wrap: wrap;
			font-size: 28upx;
			justify-content: flex-start;

			.item {
				width: calc(100% / 10);
				margin: 10upx auto;
				border-radius: 100upx;
			}

			.disabled {
				background: #efefef;
				color: #999;
			}

			.active {
				background: linear-gradient(90deg, #18EBF2, #3BC2C3);
				color: #fff;
			}
		}
	}
</style>
