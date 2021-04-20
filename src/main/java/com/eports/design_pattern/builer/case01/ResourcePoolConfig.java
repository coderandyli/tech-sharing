package com.eports.design_pattern.builer.case01;

public class ResourcePoolConfig {
    /**
     * name
     */
    private String name;
    /**
     * max total
     */
    private int maxTotal;
    /**
     * max idle
     */
    private int maxIdle;
    /**
     * min idle
     */
    private int minIdle;

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    @Override
    public String toString() {
        return "ResourcePoolConfig{" +
                "name='" + name + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", minIdle=" + minIdle +
                '}';
    }


    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 0;
        private static final int DEFAULT_MAX_IDLE = 0;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public Builder() {
        }

        public ResourcePoolConfig build() {
            // 属性之前存在依赖性，build时进行相关逻辑校验
            if (minIdle > maxIdle) {
                throw new IllegalArgumentException("maxIdle should not less than maxIdle");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (name == null) {
                throw new IllegalArgumentException("");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal < 0) {
                throw new IllegalArgumentException("maxTotal should not less than zero");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should not less than zero");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle should not less than zero");
            }
            this.minIdle = minIdle;
            return this;
        }
    }

}
