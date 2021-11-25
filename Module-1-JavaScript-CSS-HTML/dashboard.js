class Product {
    constructor(id, motorcycleLine, year, color, kmTraveled, price, details, address, phoneNumber, sellerName, picture) {
        this.productId = id,
            this.motorcycleLine = motorcycleLine,
            this.year = year,
            this.color = color,
            this.kmTraveled = kmTraveled,
            this.price = price,
            this.details = details,
            this.address = address,
            this.phoneNumber = phoneNumber,
            this.sellerName = sellerName,
            this.picture = picture
    }
};

let products = [];

function init() {
    if (getStoreRoom("motorcycleMarket") == null) {
        // // // Khởi tạo kho mẫu
        products = [
            new Product(
                productId = 1,
                motorcycleLine = "Honda Wave Alpha",
                year = 2017,
                color = "Trắng",
                kmTraveled = "10,000-19,999 km",
                price = 8500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Phong Điền",
                phoneNumber = "0984453445",
                sellerName = "Thành",
                picture = "hondaWaveAlpha.jpg"
            ),
            new Product(
                productId = 2,
                motorcycleLine = "Honda Dream",
                year = 2010,
                color = "Trắng-đen",
                kmTraveled = "Trên 50,000 km",
                price = 8500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Phong Điền",
                phoneNumber = "0984453445",
                sellerName = "Thành",
                picture = "dream.jpg"
            ),
            new Product(
                productId = 3,
                motorcycleLine = "Honda SH",
                year = 2015,
                color = "Đỏ",
                kmTraveled = "10,000-19,999 km",
                price = 26500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Tp.Huế",
                phoneNumber = "0936453445",
                sellerName = "Trang",
                picture = "hondaShRed.jpg"
            ),
            new Product(
                productId = 4,
                motorcycleLine = "Honda Future 125",
                year = 2014,
                color = "Nâu",
                kmTraveled = "20,000-49,999 km",
                price = 19500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Hương Thủy",
                phoneNumber = "0984453535",
                sellerName = "Công",
                picture = "future125.jpg"
            ),
            new Product(
                productId = 5,
                motorcycleLine = "Suzuki Gn125",
                year = 2012,
                color = "Đen",
                kmTraveled = "Trên 50,000 km",
                price = 23500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Tp.Huế",
                phoneNumber = "0984455365",
                sellerName = "Nam",
                picture = "suzukiGn125.jpg"
            ), new Product(
                productId = 6,
                motorcycleLine = "Suzuki Satria",
                year = 2017,
                color = "Đen",
                kmTraveled = "10,000-19,999 km",
                price = 21500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Phú Lộc",
                phoneNumber = "0976497445",
                sellerName = "Thành",
                picture = "suzukiSatria.jpg"
            ), new Product(
                productId = 7,
                motorcycleLine = "Yamaha Nouvo",
                year = 2014,
                color = "Trắng-đỏ",
                kmTraveled = "20,000-49,999 km",
                price = 12500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Phong Điền",
                phoneNumber = "0984418945",
                sellerName = "Lan",
                picture = "yamahaNouvo.jpg"
            ), new Product(
                productId = 8,
                motorcycleLine = "Yamaha Exciter 135",
                year = 2012,
                color = "Đỏ-đen",
                kmTraveled = "Trên 50,000 km",
                price = 17500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Tp.Huế",
                phoneNumber = "0984489445",
                sellerName = "Hải",
                picture = "yamahaEx135.jpg"
            ),
            new Product(
                productId = 9,
                motorcycleLine = "Honda Wave Alpha",
                year = 2017,
                color = "Trắng",
                kmTraveled = "10,000-19,999 km",
                price = 8500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Phong Điền",
                phoneNumber = "0984453445",
                sellerName = "Thành",
                picture = "hondaWaveAlpha.jpg"
            ),
            new Product(
                productId = 10,
                motorcycleLine = "Honda Dream",
                year = 2010,
                color = "Trắng-đen",
                kmTraveled = "Trên 50,000 km",
                price = 8500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Phong Điền",
                phoneNumber = "0984453445",
                sellerName = "Thành",
                picture = "dream.jpg"
            ),
            new Product(
                productId = 11,
                motorcycleLine = "Honda SH",
                year = 2015,
                color = "Đỏ",
                kmTraveled = "10,000-19,999 km",
                price = 26500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Tp.Huế",
                phoneNumber = "0936453445",
                sellerName = "Trang",
                picture = "hondaShRed.jpg"
            ),
            new Product(
                productId = 12,
                motorcycleLine = "Honda Future 125",
                year = 2014,
                color = "Nâu",
                kmTraveled = "20,000-49,999 km",
                price = 19500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Hương Thủy",
                phoneNumber = "0984453535",
                sellerName = "Công",
                picture = "future125.jpg"
            ),
            new Product(
                productId = 13,
                motorcycleLine = "Suzuki Gn125",
                year = 2012,
                color = "Đen",
                kmTraveled = "Trên 50,000 km",
                price = 23500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Tp.Huế",
                phoneNumber = "0984455365",
                sellerName = "Nam",
                picture = "suzukiGn125.jpg"
            ), new Product(
                productId = 14,
                motorcycleLine = "Suzuki Satria",
                year = 2017,
                color = "Đen",
                kmTraveled = "10,000-19,999 km",
                price = 21500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Phú Lộc",
                phoneNumber = "0976497445",
                sellerName = "Thành",
                picture = "suzukiSatria.jpg"
            ), new Product(
                productId = 15,
                motorcycleLine = "Yamaha Nouvo",
                year = 2014,
                color = "Trắng-đỏ",
                kmTraveled = "20,000-49,999 km",
                price = 12500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Phong Điền",
                phoneNumber = "0984418945",
                sellerName = "Lan",
                picture = "yamahaNouvo.jpg"
            ), new Product(
                productId = 16,
                motorcycleLine = "Yamaha Exciter 135",
                year = 2012,
                color = "Đỏ-đen",
                kmTraveled = "Trên 50,000 km",
                price = 17500000,
                details = "Xe nữ đi, chăm sóc thường xuyên",
                address = "Tp.Huế",
                phoneNumber = "0984489445",
                sellerName = "Hải",
                picture = "yamahaEx135.jpg"
            )
        ];
        saveStoreRoom("motorcycleMarket", products);
    } else {
        products = getStoreRoom("motorcycleMarket");
    }
}

function getStoreRoom(key) {
    return JSON.parse(window.localStorage.getItem(key));
}

function saveStoreRoom(key, data) {
    window.localStorage.setItem(key, JSON.stringify(data));
}

// // // Hiển thị danh sách sản phẩm
function showProduct() {
    let tbProduct = document.getElementById("productsShow");
    tbProduct.innerHTML = "";
    for (let i = products.length - 1; i >= 0; i--) {
        tbProduct.innerHTML += ` <a href = "details.html?id=${i}"><div class = "tbProduct">
                                                    <img src="images/${products[i].picture}" class = "imgShow">
                                                    <div><h5 class = "textTbProduct"> ${products[i].motorcycleLine} ${products[i].year}</h5>
                                                    <p class = "textTbProduct">${products[i].color} </p>
                                                    <p class = "textTbProduct"> ${formatCurrency(products[i].price)} </p>
                                                    <p class = "textTbProduct"> ${products[i].address} </p></div>
                                            </div></a> `
    }
}

function formatCurrency(number) {
    return number.toLocaleString('vi', {
        style: 'currency',
        currency: 'vnd',
    });
}

// Khởi tạo
function ready() {
    init();
    showProduct();
}

// let hondaLineList = ["SH", "SH MORE", "Air"
// ]