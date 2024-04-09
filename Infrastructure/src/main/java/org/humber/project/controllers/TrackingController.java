package org.humber.project.controllers;

import org.humber.project.domain.Tracking;
import org.humber.project.services.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trackings")
public class TrackingController {

    private final TrackingService trackingService;

    @Autowired
    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @PostMapping
    public ResponseEntity<Tracking> createTracking(@RequestBody Tracking tracking) {
        // Implement creation logic if needed
        return null;
    }

    @GetMapping("/{trackingId}")
    public Tracking getTracking(@PathVariable Long trackingId) {
        // Implement retrieval logic if needed
        return null;
    }

    @PutMapping("/{trackingId}/updateDeliveryTime")
    public ResponseEntity<Tracking> updateDeliveryTime(@PathVariable Long trackingId, @RequestParam int deliveryTime) {
        Tracking updatedTracking = trackingService.updateDeliveryTime(trackingId, deliveryTime);
        if (updatedTracking != null) {
            return ResponseEntity.ok(updatedTracking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{trackingId}")
    public ResponseEntity<Void> deleteTracking(@PathVariable Long trackingId) {
        // Implement deletion logic if needed
        return null;
    }

    @PutMapping("/{orderId}/markReceived")
    public ResponseEntity<String> markOrderReceived(@PathVariable Long orderId) {
        // Logic to update the order status in the database
        // You may also perform additional tasks here, such as sending notifications, etc.
        return ResponseEntity.ok("Order status updated successfully");
    }
}
