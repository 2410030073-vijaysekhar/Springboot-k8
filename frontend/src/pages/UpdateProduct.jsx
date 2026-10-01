import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import API from "../services/api";

function UpdateProduct() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [product, setProduct] = useState({
    name: "",
    price: "",
    quantity: "",
    imageUrl: ""
  });

  useEffect(() => {
    API.get(`/products/${id}`).then((res) => {
      setProduct(res.data);
    });
  }, []);

  const handleChange = (e) => {
    setProduct({...product,[e.target.name]: e.target.value});
  };

  const updateProduct = () => {
    API.put(`/products/${id}`, product).then(() => {
      alert("Updated");
      navigate("/admin-dashboard");
    });
  };

  return (
    <div className="container mt-4">
      <h2>Update Product</h2>

      <input className="form-control mb-2" name="name" value={product.name} onChange={handleChange}/>
      <input className="form-control mb-2" name="price" value={product.price} onChange={handleChange}/>
      <input className="form-control mb-2" name="quantity" value={product.quantity} onChange={handleChange}/>
      <input className="form-control mb-2" name="imageUrl" value={product.imageUrl} onChange={handleChange}/>

      <button className="btn btn-success" onClick={updateProduct}>Update</button>
    </div>
  );
}

export default UpdateProduct;