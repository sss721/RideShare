/**
 * 
 */
package edu.nyu.cloud.google.service;

import java.util.List;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;

import edu.nyu.cloud.beans.Route;

/**
 * @author rahulkhanna Date:05-Apr-2016
 */
public class MapServiceImpl implements MapService {

	private final GeoApiContext context;

	public MapServiceImpl() {
		this.context = new GeoApiContext().setApiKey("AIzaSyC_xRB8quFF-9SM2bxokO9KekSyoRsqZsE");
	}
	
	

	@Override
	public List<Route> fetchPossibleRoutes(String source, String destination) {
		try {
			DirectionsRoute[] routes = DirectionsApi.getDirections(context, "New Jersey","New York").await();
			for (DirectionsRoute directionsRoute : routes) {
				DirectionsLeg[] legs = directionsRoute.legs;
				directionsRoute.overviewPolyline.decodePath().stream().forEach(x-> System.out.println(x));
				for (DirectionsLeg directionsLeg : legs) {
					//System.out.println(directionsLeg.startAddress+" "+directionsLeg.endAddress);
					DirectionsStep[] steps = directionsLeg.steps;
					for (DirectionsStep directionsStep : steps) {
						//System.out.println(directionsStep.polyline.getEncodedPath());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		MapService service = new MapServiceImpl();
		service.fetchPossibleRoutes("a", "aa");
	}

}
