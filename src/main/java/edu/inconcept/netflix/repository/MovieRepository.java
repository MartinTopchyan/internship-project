package edu.inconcept.netflix.repository;

import edu.inconcept.netflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select m from Movie m where m.id = :id")
    Movie findMovieById(@Param("id") Long var1);

    @Query("select m from Movie m where m.iMDBRating > :rated ")
    List<Movie> findMoviesGreaterAvgRating(@Param("rated") Double var1);

    @Query("select m from Movie m where m.title like concat('%',:title,'%')")
    List<Movie> findMoviesByName(@Param("title") String var1);

    @Query("select  m from Movie  m inner join m.genres g where g.name = :genreName")
    List<Movie> findAllByGenre(@Param("genreName") String var1);

    @Query("select  m from Movie  m inner join m.directors d where d.name like concat('%',:directorName,'%')")
    List<Movie> findMoviesByDirector(@Param("directorName") String var1);

    @Query(value = "select m.title from movie m where m.title like %:keyWord% union all select d.name from director d  where d.name like %:keyWord% union all  select g.name from genre g where g.name like %:keyWord%",
            nativeQuery = true)
    List<String> findAllByKeyWord(@Param("keyWord") String var1);

    @Query(value = "select * from movie order by movie.id   limit 10  offset ?1", nativeQuery = true)
    List<Movie> getAllByPaging(@Param("offset") Integer offset);
}
