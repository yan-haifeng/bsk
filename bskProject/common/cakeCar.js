export default {
	car: [],
	haveCake: false,
	pushCar(data) {
		this.carHaveCake(data);
		if (!this.haveCake) {
			this.car.push(data)
		}
	},
	refCar(data){
		this.car = data
	},
	carHaveCake(data) {
		//判断购物车里是否有此蛋糕
		this.haveCake = false
		for (var i = 0; i < this.car.length; i++) {
			if (this.car[i].cakeName == data.cakeName) {
				//名字相同相同判断规格是否相同
				if (this.car[i].cakeWeight == data.cakeWeight) {
					//两样数据都相同,不添加数据,数组里相同数据+1
					this.car[i].cakeNum = (parseInt(this.car[i].cakeNum) + 1).toString()
					console.log('相同')
					this.haveCake = true
					return
				} else {
					this.haveCake = false
					console.log('规格不相同')
				}
			} else {
				this.haveCake = false
				console.log('不相同')
			}
		}
	},
	cleanCakeCar() {
		this.car = []
	}
}
