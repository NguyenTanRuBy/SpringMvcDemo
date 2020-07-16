const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const itemId = urlParams.get('id');

var item = {};
var cart = {
	item : {},
	amount : 1
}

var bigCart = [];

axios({
	method : 'get',
	url : '/DemoSpringMVC/item/getItemById',
	params : {
		id : itemId
	}
}).then(function(res) {
	var self = this;

	self.item = res.data;
	console.log(self.item);

	$("#cardTitle").text(self.item.name);
	$("#cardImg").attr("src", self.item.img);
	$("#itemPrice").text("Price: " + self.item.price + " VND");
});

function buyItem() {
	var self = this;

	self.cart.item = self.item;

	if (JSON.parse(window.localStorage.getItem("cart")) != null) {
		self.bigCart = JSON.parse(window.localStorage.getItem("cart"));
	}

	if (typeof self.bigCart !== 'undefined' && self.bigCart.length > 0) {
		// the array is defined and has at least one element
		for (let i = 0; i < self.bigCart.length; i++) {
			if (self.bigCart[i].item.id == self.cart.item.id) {
				self.bigCart[i].amount += 1;
				break;
			} else {
				if (i == (self.bigCart.length - 1)) {
					self.bigCart.push(self.cart);
					break;
				}
			}
		}
	} else {
		self.bigCart.push(self.cart);
	}

	window.localStorage.setItem("cart", JSON.stringify(self.bigCart));
	console.log("---------cart on local--------------");
	console.log(JSON.parse(window.localStorage.getItem("cart")));

	console.log(self.item);
	console.log(self.cart.item);
	console.log(self.cart.amount);
	console.log(self.bigCart)

}