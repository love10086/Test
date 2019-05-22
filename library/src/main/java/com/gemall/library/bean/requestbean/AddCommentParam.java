package com.gemall.library.bean.requestbean;

import java.util.List;

public class AddCommentParam {

    /**
     * orderUinqueId : 38c7a157-91ac-4a99-8eb0-5ca9237b1c04
     * orderCode : sample string 2
     * isAnonymous : 1
     * evaluate : [{"productUniqueId":"9a753ed8-3bcd-4541-a9e8-9676f6a8b436","evaluateContent":"sample string 2","evaluateLevel":1,"evaluateStar":1,"evaluateImage":["sample string 1","sample string 2"]},{"productUniqueId":"9a753ed8-3bcd-4541-a9e8-9676f6a8b436","evaluateContent":"sample string 2","evaluateLevel":1,"evaluateStar":1,"evaluateImage":["sample string 1","sample string 2"]}]
     */

    private String orderUinqueId;
    private String orderCode;
    private int isAnonymous;
    private List<EvaluateBean> evaluate;

    public String getOrderUinqueId() {
        return orderUinqueId;
    }

    public void setOrderUinqueId(String orderUinqueId) {
        this.orderUinqueId = orderUinqueId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(int isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public List<EvaluateBean> getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(List<EvaluateBean> evaluate) {
        this.evaluate = evaluate;
    }

    public static class EvaluateBean {
        /**
         * productUniqueId : 9a753ed8-3bcd-4541-a9e8-9676f6a8b436
         * evaluateContent : sample string 2
         * evaluateLevel : 1
         * evaluateStar : 1
         * evaluateImage : ["sample string 1","sample string 2"]
         */

        private String productUniqueId;
        private String evaluateContent;
        private int evaluateLevel;
        private int evaluateStar;
        private List<String> evaluateImage;

        public String getProductUniqueId() {
            return productUniqueId;
        }

        public void setProductUniqueId(String productUniqueId) {
            this.productUniqueId = productUniqueId;
        }

        public String getEvaluateContent() {
            return evaluateContent;
        }

        public void setEvaluateContent(String evaluateContent) {
            this.evaluateContent = evaluateContent;
        }

        public int getEvaluateLevel() {
            return evaluateLevel;
        }

        public void setEvaluateLevel(int evaluateLevel) {
            this.evaluateLevel = evaluateLevel;
        }

        public int getEvaluateStar() {
            return evaluateStar;
        }

        public void setEvaluateStar(int evaluateStar) {
            this.evaluateStar = evaluateStar;
        }

        public List<String> getEvaluateImage() {
            return evaluateImage;
        }

        public void setEvaluateImage(List<String> evaluateImage) {
            this.evaluateImage = evaluateImage;
        }
    }
}
