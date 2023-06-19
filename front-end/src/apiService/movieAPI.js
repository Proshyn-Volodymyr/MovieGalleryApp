import axios from "axios";
import { Loading } from "notiflix/build/notiflix-loading-aio";

export const apiParameters = {
  TMDB_KEY: "497b2919aae9c265ed594e43d01e8d1b",
  BASE_URL: "http://localhost:8080/",
  ORIGINAL_IMG: (imgPath) => `https://image.tmdb.org/t/p/original/${imgPath}`,
  W500_IMG: (imgPath) => `https://image.tmdb.org/t/p/w500/${imgPath}`,
};
const { TMDB_KEY, BASE_URL } = apiParameters;

async function fetchAPI(url = "") {
  Loading.circle({ clickToClose: true });
  const response = await axios.get(url);
  try {
    const data = response.data;
    if (response.status === 200) {
      Loading.remove();
      return response.data;
    } else {
      console.log(`this is error ---> ${response.status}}`);
      Loading.remove();
      return data;
    }
  } catch (error) {
    console.log(`this is error ---> ${error}`);
  }
}
export function getNowPlaying() {
  return fetchAPI(`movie/now_playing`);
}
export function getMovieDetail(id) {
  return fetchAPI(`/movie/movie_details?id=${id}`);
}
export function getVideo(id) {
  return fetchAPI(`movie/${id}/videos`);
}
