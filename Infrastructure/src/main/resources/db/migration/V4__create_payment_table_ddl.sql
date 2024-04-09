CREATE TABLE payment
(
    payment_id    INT AUTO_INCREMENT PRIMARY KEY,
    order_id      INT, 
    order_amount  DECIMAL(10,2), 
    payment_type  VARCHAR(50),
    FOREIGN KEY (order_id) REFERENCES ORDERS(id) 
);
