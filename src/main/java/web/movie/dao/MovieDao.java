package web.movie.dao;

import java.util.List;
import java.util.Map;

import com.web.store.model.MovieBean;
import com.web.store.model.Movie_Genre;


public interface MovieDao {
	List<Movie_Genre> getGenreList();

	Map<Integer, MovieBean> saveMovie(MovieBean movieBean);

	Map<Integer, MovieBean> getMovie();

	MovieBean getMovieImg(Integer movieId);

	void MovieDelete(Integer moviemId);

	Map<Integer, MovieBean> MovieUpdata(MovieBean movieBean, long sizeInBytes);

	List<MovieBean> MovieUpdateAjax(Integer moviemId);
}
