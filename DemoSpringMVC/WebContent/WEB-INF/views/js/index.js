var items = [];
var itemByCategory = [];

updateItemCartCount();

function getAllItem() {
	var self = this;
	axios({
		method: 'get',
		url: '/DemoSpringMVC/item/getAllItem'
	}).then(function (res) {
		self.items = res.data;
	});
}

function categoryClick(button) {
	var self = this;
	var requestUrl = '/DemoSpringMVC/item/getItemByCategory?name=' + button.id;

	axios({
		method: 'get',
		url: requestUrl
	})
		.then(
			function (res) {
				self.itemByCategory = res.data;
				console.log(self.itemByCategory);

				// / rename category
				$("#categoryViewer").html("<H3>" + button.id + "</H3>");
				$("#categoryViewer")
					.append(
						"<div class='card-deck' id='categoryViewerCardDeck' ></div>")
				$("#categoryViewerBottom")[0].scrollIntoView();

				for (let item = 0; item <= self.itemByCategory.length; item++) {
					$("#categoryViewerCardDeck")
						.append(
							"\
										<div class='card mb-4'>\
											<img class='card-img-top' src='"
							+ self.itemByCategory[item].img
							+ "'\
												alt='Card image'>\
											<div class='card-body'>\
												<h4 class='card-title'>"
							+ self.itemByCategory[item].name
							+ "</h4>\
												<p class='card-text'>Description</p>\
												<a href='/DemoSpringMVC/item?id="
							+ self.itemByCategory[item].id
							+ "' class='btn btn-success stretched-link'>Detail</a>\
											</div>\
										</div>");
				}

			});
}

function topSaleImgClick(id) {
	window.location.href = "/DemoSpringMVC/item?id=" + id;
}

function updateItemCartCount() {
	var storage = JSON.parse(window.localStorage.getItem("cart"));
	if (storage != null) {
		$("#shoppingBagBadge").text(storage.length);
	}
	else {
		$("#shoppingBagBadge").text("0");
	}
}

function categorySearchClick(name) {
	$("#searchField").val(name);
}

function search() {
	window.location.href = "/DemoSpringMVC/category/searchByCategory?name=" + $("#searchField").val();

}








