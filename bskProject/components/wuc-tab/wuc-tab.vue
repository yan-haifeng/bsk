<template>
  <scroll-view class="wuc-tab" :class="tabClass" :style="tabStyle" scroll-with-animation scroll-x :scroll-left="scrollLeft">
    <div v-if="!textFlex">
      <div class="wuc-tab-item"  v-for="(item,index) in tabList" :key="index" :id="index" @tap="tabSelect(index,$event)">
        <text :class="item.icon"></text>
        <span :class="[index === tabCur ? selectClass + ' cur':'']">{{item.cakeclassName}}</span>
      </div>
    </div>

    <div class="flex text-center" v-if="textFlex">
      <div class="wuc-tab-item flex-sub" :class="index === tabCur ? selectClass + ' cur':''" v-for="(item,index) in tabList" :key="index" :id="index" @tap="tabSelect(index,$event)">
        <text :class="item.icon"></text>
        <span>{{item.cakeclassName}}</span>
      </div>
    </div>
  </scroll-view>
</template>
<script>
export default {
    name: 'wuc-tab',
    data() {
        return {};
    },
    props: {
        tabList: {
            type: Array,
            default() {
                return [];
            }
        },
        tabCur: {
            type: Number,
            default() {
                return 0;
            }
        },
        tabClass: {
            type: String,
            default() {
                return '';
            }
        },
        tabStyle: {
            type: String,
            default() {
                return '';
            }
        },
        textFlex: {
            type: Boolean,
            default() {
                return false;
            }
        },
        selectClass: {
            type: String,
            default() {
                return 'text-blue';
            }
        }
    },
    methods: {
        tabSelect(index, e) {
            if (this.currentTab === index) return false;
            this.$emit('update:tabCur', index);
            this.$emit('change', index);
        }
    },
    computed: {
        scrollLeft() {
            return (this.tabCur - 1) * 60;
        }
    }
};
</script>
<style>
div,
scroll-view,
swiper {
	display: block;
	font-size: 35rpx;
	box-sizing: border-box;
}
.wuc-tab {
	float: left;
	width: 600upx;
    white-space: nowrap;
}
.wuc-tab-item {
    height: 90upx;
    display: inline-block;
    line-height: 90upx;
    margin: 0 10upx;
    padding: 0 20upx;
}
.wuc-tab-item span {
}
.wuc-tab-item .cur {
	box-sizing: border-box;
	padding: 15upx 0;
    border-bottom: 10upx solid;
}

.wuc-tab.fixed {
	position: fixed;
	width: 100%;
	top: 0;
	z-index: 1024;
	box-shadow: 0 1upx 6upx rgba(0, 0, 0, 0.1);
}

.flex {
    display: flex;
}
.text-center {
    text-align: center;
}
.flex-sub {
    flex: 1;
}
.text-blue{
  color:#0081ff;
}
.text-white{
  color:#ffffff;
}
.bg-white{
    background-color: #ffffff;
}
.bg-blue{
    background-color: #0081ff;
}
.text-orange{
  color: #f37b1d;
}
.text-pink {
	color: #FF1850;
}

.text-xl {
	font-size: 35upx;
}
</style>
