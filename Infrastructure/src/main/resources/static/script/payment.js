function selectPaymentOption(option) {
    const creditCardOption = document.getElementById('creditCardOption');
    const giftCardOption = document.getElementById('giftCardOption');

    if (option === 'creditCard') {
        creditCardOption.classList.add('selected');
        giftCardOption.classList.remove('selected');
    } else if (option === 'giftCard') {
        giftCardOption.classList.add('selected');
        creditCardOption.classList.remove('selected');
    }

    document.getElementById('continueButton').disabled = false;
}

function continueToCheckout() {
    const selectedPaymentOption = document.querySelector('.payment-option.selected');

    if (!selectedPaymentOption) {
        alert('Please select a payment option.');
        return;
    }

    const paymentType = selectedPaymentOption.id === 'creditCardOption' ? 'Debit/Credit Card' : 'Gift Card';

    // Send the selected payment type to the server
    sendPaymentType(paymentType);
}

function sendPaymentType(paymentType) {
    const orderId = 123; // Replace with actual order ID

    // Get the order amount from the HTML attribute
    const orderAmountElement = document.getElementById('orderAmount');
    const orderAmount = parseFloat(orderAmountElement.getAttribute('data-amount'));

    const data = {
        orderId: orderId,
        orderAmount: orderAmount,
        paymentType: paymentType
    };

    fetch('/api/payments', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to send payment type.');
        }
        return response.json();
    })
    .then(data => {
        console.log('Payment type sent successfully:', data);
        // Optionally, you can perform additional actions here, such as showing a success message or redirecting to another page
    })
    .catch(error => {
        console.error('Error sending payment type:', error);
        // Optionally, you can handle errors here, such as displaying an error message to the user
    });
}

function goBackToIndex() {
    window.location.href = '/index.html';
}
