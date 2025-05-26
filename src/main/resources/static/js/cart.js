// 加载购物车数据
async function loadCart() {
    const response = await fetch('/api/cart');
    const items = await response.json();

    const container = document.getElementById('cart-items');
    container.innerHTML = items.map(item => `
        <div class="cart-item">
            <img src="/images/${item.product.image}">
            <div class="info">
                <h3>${item.product.name}</h3>
                <p>单价：￥${item.product.price.toFixed(2)}</p>
                <div class="quantity-control">
                    <button onclick="updateQuantity(${item.id}, -1)">-</button>
                    <span>${item.quantity}</span>
                    <button onclick="updateQuantity(${item.id}, 1)">+</button>
                </div>
            </div>
        </div>
    `).join('');
}