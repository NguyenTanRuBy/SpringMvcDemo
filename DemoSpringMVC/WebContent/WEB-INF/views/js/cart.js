/**
 * 
 */
var storage = JSON.parse(window.localStorage.getItem("cart"));
var message = "";

var cartData = {
	userName: "",
	itemId: 0,
	amount: 0,
	totalPrice: 0
}

renderData();

function renderData() {
	if (storage == null) {
		$("#tableBody").empty();
		$("#tableBody").append("<tr>\
					<td><img src='img/default_img.png' width=80px height=80px alt='img'></td>\
					<td>not available</td>\
					<td>not available</td>\
					<td>not available</td>\
					<td>not available</td>\
				</tr>")
	}
	else {
		for (let item = 0; item < storage.length; item++) {
			$("#tableBody").append("<tr>\
							<td><img src='" + storage[item].item.img + "' width=100px height=100px alt='img'></td>\
							<td>"+ storage[item].item.name + "</td>\
							<td>"+ storage[item].amount + "</td>\
							<td>"+ storage[item].item.price + "</td>\
							<td>" + storage[item].totalPrice + "</td>\
						</tr>")
		}
	}
}

function submit() {
	if (storage == null) {
		// disable submit button

	}
	else {
		var self = this;
		axios({
			method: 'get',
			url: '/DemoSpringMVC/username'
		}).then(async function (res) {
			self.cartData.userName = res.data;

			for (let item = 0; item < self.storage.length; item++) {
				self.cartData.amount = self.storage[item].amount;
				self.cartData.totalPrice = self.storage[item].totalPrice;
				self.cartData.itemId = self.storage[item].item.id;

				await axios({
					method: 'post',
					url: '/DemoSpringMVC/cart/addCart',
					data: self.cartData
				}).then(function (data) {
					self.message = data.data;
				});

			}
			
			window.localStorage.removeItem("cart");
			self.storage = null;
			$("#submitModal").modal("hide");
			self.renderData();
		});
	}
}















