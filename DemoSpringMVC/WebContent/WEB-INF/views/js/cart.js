/**
 * 
 */
var storage;
var message = "";
var idConfirmDelete = 0;

var cartData = {
	userName: "",
	itemId: 0,
	amount: 0,
	totalPrice: 0
}

renderData();

function renderData() {
	this.storage = JSON.parse(window.localStorage.getItem("cart"));

	$("#tableBody").empty();
	if (storage == null || storage.length == 0) {
		$("#tableBody").append("\
				<tr>\
					<td><img src='img/default_img.png' width=100px height=100px alt='img'></td>\
					<td>not available</td>\
					<td>not available</td>\
					<td>not available</td>\
					<td>not available</td>\
					<td>not available</td>\
				</tr>")

		$("#btnSubmit").prop("disabled", true);
	}
	else {
		for (let item = 0; item < storage.length; item++) {
			$("#tableBody").append("<tr>\
							<td><img src='" + storage[item].item.img + "' width=100px height=100px alt='img'></td>\
							<td>"+ storage[item].item.name + "</td>\
							<td>"+ storage[item].amount + "</td>\
							<td>"+ storage[item].item.price + "</td>\
							<td>" + storage[item].totalPrice + "</td>\
							<td>\
								<a><span class='material-icons' style='color: gold; cursor: pointer;' data-toggle='tooltip' title='Edit'>create</span></a>\
								<a onclick='confirmDelete(" + storage[item].item.id + ")' data-toggle='tooltip' title='Delete'><span class='material-icons' style='color: red; cursor: pointer;'>delete</span></a>\
							</td>\
						</tr>")
		}
	}
}

function submit() {
	if (storage == null) {

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
			// disable submit button
			$("#btnSubmit").prop("disabled", true);
			self.renderData();
		});
	}
}

function confirmDelete(id) {
	$("#confirmDelete").modal("show");
	this.idConfirmDelete = id;
}

function deleteItem() {
	for (let index = 0; index < storage.length; index++) {
		if (storage[index].item.id == this.idConfirmDelete) {
			storage.splice(index, 1);
			break;
		}
	}

	$("#confirmDelete").modal("hide");

	//window.localStorage.removeItem("cart");
	window.localStorage.setItem("cart", JSON.stringify(storage));
	renderData();
}














