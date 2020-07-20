const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const categoryName = urlParams.get('name');

var items = {};

initData();

async function initData() {
	await axios({
		method: 'get',
		url: '/DemoSpringMVC/item/getItemByCategory',
		params: {
			name: categoryName
		}
	}).then(function (res) {
		var self = this;
		self.items = res.data;
		self.renderData();
	})
}


function renderData() {
	$("#tableBody").empty();

	if (items == null) {
		$("#tableBody").append("<tr>\
					<td><img src='img/default_img.png' width=80px height=80px alt='img'></td>\
					<td>not available</td>\
					<td>not available</td>\
					<td>not available</td>\
					<td>not available</td>\
				</tr>")
	}
	else {
		for (let item = 0; item < items.length; item++) {
			$("#tableBody").append("<tr>\
							<td><img src='../" + self.items[item].img + "' width=100px height=100px alt='img'></td>\
							<td>"+ self.items[item].name + "</td>\
							<td>"+ self.items[item].price + "</td>\
							<td><a class='btn btn-success' href='/DemoSpringMVC/item?id=" + self.items[item].id + "'>Buy</a></td>\
						</tr>")
		}
	}
}