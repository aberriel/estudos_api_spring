package com.sinqia.teste_api.models.uber;

import com.sinqia.teste_api.models.uber.Driver;
import com.sinqia.teste_api.models.uber.EditableFields;
import com.sinqia.teste_api.models.uber.Guest;
import com.sinqia.teste_api.models.uber.Location;
import com.sinqia.teste_api.models.uber.Product;
import com.sinqia.teste_api.models.uber.SimpleLocation;
import com.sinqia.teste_api.models.uber.Vehicle;
import com.sinqia.teste_api.models.uber.WayPoints;

public class GuestTrip {
	public int begin_trip_time;
	public boolean can_tip;
	public String clint_fare;
	public String client_fare_without_tip;
	public String currency_code;
	public Location destination;
	public Driver driver;
	public int dropoff_time;
	public String expense_memo;
	public Guest guest;
	public String location_uuid;
	public String note_for_driver;
	public Location pickup;
	public Product product;
	public String request_id;
	public int request_time;
	public String requester_name;
	public String requester_uuid;
	public String status;
	public int surge_multiplier;
	public float trip_distance_miles;
	public int trip_duration_seconds;
	public SimpleLocation trip_end_location;
	public Vehicle vehicle;
	public WayPoints waypoints;
	public EditableFields editable_fields;
}
