import "./LoginPage.css";
import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import { useNavigate } from "react-router-dom";
/*redux*/
import { useDispatch } from "react-redux";
import { addUser } from "../../../Redux/userSlice";
import { addToken } from "../../../Redux/tokenSlice";
/*api*/
import { baseUrl } from "../../../api/baseUrl";
import axios from "axios";
/*components*/
import HelpButton from "../../../Components/Button.Components/HelpButtonOne/HelpButtonOne";
import ForgotButton from "../../../Components/Button.Components/HelpButtonTwo/HelpButtonTwo";
import BrandImg from "../../../Components/Image.Components/Brand-image/Brand-Image";

export default function LoginPage(props) {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const data = { username: username, password: password };
    const userWithToken = await axios.post(baseUrl + "/login", data);

    dispatch(addToken(userWithToken.data.token));
    dispatch(addUser(userWithToken.data.user));

    navigate("/user-welcome");
  };

  return (
    <div className="login-page">
      <h1 className="login-header">Welcome!</h1>
      <br />
      <BrandImg />
      <br />

      <label className="login-label">Username</label>
      <input
        type="text"
        id="username"
        name="username"
        className="login-input"
        placeholder="Username"
        onChange={(event) => setUsername(event.target.value)}
        required
      />
      <label className="login-label">Password</label>
      <input
        type="password"
        id="password"
        name="password"
        className="login-input"
        placeholder="Password"
        onChange={(event) => setPassword(event.target.value)}
        required
      />

      <br />

      <button className="login-button" onClick={handleSubmit}>
        Login
      </button>

      <br />
      <ForgotButton buttonName="Forgot Password" />
      <br />
      <HelpButton buttonName="Help?" />
    </div>
  );
}
