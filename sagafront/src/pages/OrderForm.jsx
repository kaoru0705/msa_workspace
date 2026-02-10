import { useRef } from "react";

export default function Login() {
  const productIdRef = useRef(null);
  const productNameRef = useRef(null);

/*------------------------------------------
주문 요청
------------------------------------------*/
  const order = () => {
    const payload = {
      productId: productIdRef.current.value,
      productName: productNameRef.current.value,
    };

    fetch("http://localhost:9000/api/orders", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(payload),
    })
      .then((res) => {
        if (!res.ok) throw new Error("주문 오류");
        return res.json();
      })
      .then((data) => console.log("주문 결과", data))
      .catch((err) => console.error(err));
  };

  return (
    <div
      style={{
        width: 360,
        margin: "120px auto",
        padding: "28px 24px",
        borderRadius: 12,
        background: "#ffffff",
        boxShadow: "0 10px 30px rgba(0,0,0,0.1)",
        fontFamily: "system-ui, -apple-system, sans-serif",
      }}
    >
      <h2
        style={{
          textAlign: "center",
          marginBottom: 24,
          color: "#333",
        }}
      >
        주문서
      </h2>

      <input
        ref={productIdRef}
        placeholder="상품 PK"
        style={{
          width: "90%",
          padding: "10px 12px",
          margin: "6px 0 16px",
          borderRadius: 8,
          border: "1px solid #ddd",
          outline: "none",
          fontSize: 14,
        }}
      />

      <input
        ref={productNameRef}
        placeholder="상품명"
        style={{
          width: "90%",
          padding: "10px 12px",
          margin: "6px 0 24px",
          borderRadius: 8,
          border: "1px solid #ddd",
          outline: "none",
          fontSize: 14,
        }}
      />

      <button
        onClick={order}
        style={{
          width: "100%",
          padding: "12px 0",
          borderRadius: 8,
          border: "none",
          background: "#4f46e5",
          color: "#fff",
          fontSize: 15,
          fontWeight: 600,
          cursor: "pointer",
        }}
      >
        주문 요청
      </button>
    </div>
  );
}
