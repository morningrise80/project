document.addEventListener('DOMContentLoaded', function() {
    // Function to generate a random delivery time (between 5 to 30 minutes)
    function generateDeliveryTime() {
        return Math.floor(Math.random() * (30 - 5 + 1)) + 5; // Random number between 5 to 30
    }

    // Function to update the delivery timer and send the updated time to the server
    function updateTimer() {
        var deliveryTime = generateDeliveryTime();
        var timerElement = document.getElementById('delivery-timer');
        timerElement.textContent = 'Time Remaining: ' + deliveryTime + ' minutes';

        // Send the updated delivery time to the server
        sendDeliveryTime(deliveryTime);
    }

    // Function to send the updated delivery time to the server
    function sendDeliveryTime(deliveryTime) {
        var xhr = new XMLHttpRequest();
        xhr.open('PUT', '/api/trackings/1/updateDeliveryTime?deliveryTime=' + deliveryTime, true);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                console.log('Delivery time updated successfully!');
            }
        };
        xhr.send();
    }

    // Initial update of the timer
    updateTimer();

    // Update the timer every minute
    setInterval(updateTimer, 60000); // 60000 milliseconds = 1 minute

    function markOrderReceived() {
        // Send a request to the backend to mark the order as received
        var xhr = new XMLHttpRequest();
        xhr.open('PUT', '/api/trackings/1/markReceived', true); // Assuming /api/trackings/{trackingId}/markReceived updates the order status
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    console.log('Order status updated successfully!');
                    // Optionally, perform additional actions here (e.g., display a success message, redirect to another page)
                } else {
                    console.error('Failed to update order status.');
                    // Optionally, handle errors here (e.g., display an error message)
                }
            }
        };
        xhr.send();
    }

    function sendDeliveryTime(deliveryTime) {
        var xhr = new XMLHttpRequest();
        xhr.open('PUT', '/api/trackings/1/updateDeliveryTime', true);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                console.log('Delivery time updated successfully!');
            }
        };
    
        // Create an object with deliveryTime and orderStatus
        var data = {
            deliveryTime: deliveryTime,
            orderStatus: 'Pending' // Set the order status to 'Pending'
        };
    
        xhr.send(JSON.stringify(data));
    }
});
