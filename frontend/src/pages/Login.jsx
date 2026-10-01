import { useState } from "react";
import { useNavigate } from "react-router-dom";
import API from "../services/api";

function Login() {
  const navigate = useNavigate();

  const [login, setLogin] = useState({
    email: "",
    password: ""
  });

  const handleChange = (e) => {
    setLogin({
      ...login,
      [e.target.name]: e.target.value
    });
  };

  const handleLogin = () => {
    API.post("/auth/login", login)
      .then((res) => {
        const role = res.data.role;
        localStorage.setItem("role", role);

        if (role === "ADMIN") {
          navigate("/admin-dashboard");
        } else {
          navigate("/customer-dashboard");
        }
      })
      .catch(() => {
        alert("Invalid login credentials");
      });
  };

  return (
    <div className="container mt-5">
      <h2>Login</h2>

      <input className="form-control mb-2" name="email" placeholder="Email" onChange={handleChange}/>
      <input className="form-control mb-2" type="password" name="password" placeholder="Password" onChange={handleChange}/>

      <button className="btn btn-primary" onClick={handleLogin}>Login</button>

      <p className="mt-2">
        Don't have an account?{" "}
        <span style={{cursor:"pointer",color:"blue"}} onClick={()=>navigate("/signup")}>
          Signup
        </span>
      </p>
    </div>
  );
}

export default Login;