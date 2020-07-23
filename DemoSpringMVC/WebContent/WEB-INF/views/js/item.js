const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const itemId = urlParams.get('id');

var item = {};
var cart = {
	item: {},
	amount: 1,
	totalPrice: 0
}

var bigCart = [];

$("#success-alert").hide();

updateItemCartCount();

axios({
	method: 'get',
	url: '/DemoSpringMVC/item/getItemById',
	params: {
		id: itemId
	}
}).then(function (res) {
	var self = this;

	self.item = res.data;

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
		for (let i = 0; i < self.bigCart.length; i++) {
			// if add the same item
			if (self.bigCart[i].item.id == self.cart.item.id) {
				self.bigCart[i].amount += 1;
				self.bigCart[i].totalPrice = self.bigCart[i].item.price * self.bigCart[i].amount;
				break;
			} else {
				if (i == (self.bigCart.length - 1)) {
					self.cart.totalPrice = self.cart.item.price
					self.bigCart.push(self.cart);
					break;
				}
			}
		}
		// for the first item add to cart	
	} else {
		self.cart.totalPrice = self.cart.item.price
		self.bigCart.push(self.cart);

	}

	window.localStorage.setItem("cart", JSON.stringify(self.bigCart));

	updateItemCartCount();

	$("#success-alert").text("ADD " + countItemAmount(itemId));

	$("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
		$("#success-alert").slideUp(500);
	})
};

function updateItemCartCount() {
	var storage = JSON.parse(window.localStorage.getItem("cart"));
	if (storage != null) {
		$("#shoppingBagBadge").text(storage.length);
	}
	else {
		$("#shoppingBagBadge").text("0");
	}
}

function countItemAmount(id) {
	var storage = JSON.parse(window.localStorage.getItem("cart"));
	for (let index = 0; index < storage.length; index++) {
		if (storage[index].item.id == id) {
			return storage[index].amount;
		}
	}

}











