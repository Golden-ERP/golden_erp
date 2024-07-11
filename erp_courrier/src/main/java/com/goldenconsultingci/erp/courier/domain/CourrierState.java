package com.goldenconsultingci.erp.courier.domain;

public enum CourrierState {

    DRAFT {
        @Override
        public boolean isInDraft() {
            return true;
        }
    },
    IMPUTED {
        @Override
        public boolean isInImputed() {
            return true;
        }
    },

    SUBMITTED {
        @Override
        public boolean isInSubmitted() {
            return true;
        }
    };

    public boolean isInImputed() {
        return false;
    }
    public boolean isInSubmitted() {
        return false;
    }

    public boolean isInDraft() {
        return false;
    }
}
