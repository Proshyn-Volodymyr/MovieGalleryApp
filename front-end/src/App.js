import { Route, Routes, useParams } from "react-router-dom";
import "./App.css";
import HomeView from "./views/HomeView";
import { useState } from "react";
import { AuthProvider } from "./contexts/AuthContext";
import NotFoundView from "./views/NotFoundView/NotFoundView";
import FormView from "./views/FormView/FormView";
import MovieDetailsView from "./views/MovieDetailsView/MovieDetailsView";
// import MyLibraryView from "./views/MyLibraryView/MyLibraryView";

function App() {
  const [isModalVisible, setIsModalVisible] = useState(true);
  // const reqBody = {
  //   username: "username",
  //   password: "password",
  // };

  // fetch("api/v1/auth/authenticate", {
  //   headers: { "Content-type": "application/json" },
  //   method: "post",
  //   body: JSON.stringify(reqBody),
  // });
  return (
    <AuthProvider>
      <div className="App">
        <Routes>
          <Route
            path="/"
            element={
              <HomeView
                isModalVisible={isModalVisible}
                setIsModalVisible={setIsModalVisible}
              />
            }
          >
            <Route
              path="/form"
              element={
                <FormView
                  isModalVisible={isModalVisible}
                  setIsModalVisible={setIsModalVisible}
                />
              }
            ></Route>
          </Route>
          <Route
            path="/movie/movie_details/:movieId"
            element={<MovieDetailsView />}
          ></Route>
          {/* <Route path="/my-library" element={<MyLibraryView />}></Route>
          <Route path="*" element={<NotFoundView />}></Route> */}
        </Routes>
      </div>
    </AuthProvider>
    // <div className="App">
    //   <Routes>
    //     <Route path="/" element={<HomeView></HomeView>}></Route>
    //   </Routes>
    // </div>
  );
}

export default App;
