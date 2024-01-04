package api;

import java.util.List;


import pojo.LayoutModel.Layout;
import pojo.Page;

public class World {
	
	private static Layout layout;
	private static List<Page> movie;
	/**
	 * @return the layout
	 */
	public static Layout getLayout() {
		return layout;
	}
	/**
	 * @param layout the layout to set
	 */
	public static void setLayout(Layout layout) {
		World.layout = layout;
	}
	/**
	 * @return the movie
	 */
	public static List<Page> getMovie() {
		return movie;
	}
	/**
	 * @param movie the movie to set
	 */
	public static void setMovie(List<Page> movie) {
		World.movie = movie;
	}
	

}
