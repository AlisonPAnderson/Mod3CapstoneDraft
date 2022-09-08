import "./Sign-UpPage.css";
import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import { useNavigate } from "react-router-dom";
/*api*/
import axios from "axios";
import { baseUrl } from "../../../api/baseUrl";
/*components*/
import HelpButton from "../../../Components/Button.Components/HelpButtonOne/HelpButtonOne";
import TextBanner from "../../../Components/Banner.Component/Text-Banner.Component";

export default function SignUpPage(props) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    const data = {
      username: username,
      password: password,
      confirmPassword: confirmPassword,
      role: "USER",
    };

    try {
      if (password === confirmPassword) {
        const response = await axios.post(baseUrl + "/register", data);
        alert("Registration Successful");
        console.log(response);
        navigate("/login");
      } else {
        alert("Password and Confirm Password must match!");
      }
    } catch (err) {
      if (!err?.response) {
        alert("No Server Response");
      } else if (err.response?.status === 409) {
        alert("Username Taken");
      } else {
        alert("Registration Failed");
      }
    }
  };

  return (
    <div className="SignUp-Page">
      <br />
      <img src=" " alt="placeHolder" className="Brand-Border" />
      <TextBanner text="Just a few questions" />
      <br />

      <label className="SignUp-label">Username</label>
      <input
        type="text"
        id="username"
        name="username"
        className="SignUp-input"
        placeholder="Username"
        onChange={(event) => setUsername(event.target.value)}
        required
      />
      <label className="SignUp-label">Password</label>
      <input
        type="password"
        id="password"
        name="password"
        className="SignUp-input"
        placeholder="Password"
        onChange={(event) => setPassword(event.target.value)}
        required
      />
      <input
        type="password"
        id="password-confirm"
        name="confirmPassword"
        className="SignUp-input"
        placeholder="Confirm Password"
        onChange={(event) => setConfirmPassword(event.target.value)}
        required
      />
      <button className="SignUp-button" onClick={handleSubmit}>
        Sign-up
      </button>

      <br />
      <HelpButton buttonName="Help?" />
    </div>
  );
}

/*
  Removed for now

  <TextInputOne textPlaceHolder='email'/>
  <br/>
  <TextInputOne textPlaceHolder='dietary goals'/>
  <br/>
  <TextInputOne textPlaceHolder='dietary restrictions'/>
  <br/>
  */
