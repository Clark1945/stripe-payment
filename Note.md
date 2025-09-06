### Stripe Card Payment

---

參考Script的官方文件，配合AI建立前端的付款頁面。
使用HTML/CSS/JS
使用Script.js，作為交易流程的驗證。

---

流程如下
1. 前端用戶在Script.js的SDK產生出的iframe中輸入卡號，並點選購買。
2. 我需要先使用Script.js的createPaymentMethod方法先進行消費者的信用卡檢核。
3. 檢核通過後，會得到一個paymentMethod.id，接著使用id發送後端進行交易的建立(createPaymentIntention)。
4. 最後使用paymentIntention取得的clientSecret進行交易最後的confirmCardPayment()
5. 前端交易顯示交易完成。

---

我沒有使用前端框架，而是純粹的HTML。所以會遇到網頁的CORS問題，因此我在後端開啟了允許任何來源(測試用)。

---

交易完成後，我可以在Script dashboard看到交易的紀錄。同時前端的public API Key與後端的private API Key，我可以一併看到。

---

publicKey可以顯示給html沒關係，但是private API key一定要保管好，不可以hardcore寫在程式碼裡面(不管是code還是application.properties)
建立env
將Script的private API Key放在 .env，避免hardcore在檔案中。

---

建立swagger文件讓之後自己也知道怎麼用

---
將strip打包成docker image

---

輸入
docker run --name stripe-demo-container -p 8080:8080 --env-file .env stripe-demo
執行容器

---