    // constructor(id, motorcycleLine, year, color, kmTraveled, price, details, address, phoneNumber, sellerName, picture) {

function addProduct() {
    let productId = getLastestProductId() + 1;
    let motorcycleLine = document.getElementById("motorcycleLine").value;
    let year = document.getElementById("year").value;
    let color = document.getElementById("color").value;
    let kmTraveled = document.getElementById("km").value;
    let price = Number(document.getElementById("price").value);
    let details = document.getElementById("details").value;
    let address = document.getElementById("address").value;
    let phoneNumber = String(document.getElementById("phoneNumber").value);
    let sellerName = document.getElementById("sellerName").value;
    let picture = document.getElementById("picture").value;

    let product = new Product(productId, motorcycleLine, year, color, kmTraveled, price, details, address, phoneNumber, sellerName, picture);
        products.push(product);
        saveStoreRoom("motorcycleMarket", products);
        showProduct();
    reset();

}
function getLastestProductId() {
    let prods = [...products];
    return prods.sort(function (prod1, prod2) {
        return prod2.productId - prod1.productId;
    })[0].productId;

}
var start = 1990;
var end = new Date().getFullYear();
var optionsYears = "";
for (var year = end; year >= start; year--) {
    optionsYears += `<option>  ${year} </option>`;
}
document.getElementById("year").innerHTML = optionsYears;
