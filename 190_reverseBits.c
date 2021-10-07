// easy
// arithmetic

uint32_t reverseBits(uint32_t n) {
    uint32_t result = 0;
    uint32_t bit;
    for (int i = 0; i < 32; i++) {
        bit = n & ((uint32_t)1 << i);
        bit >>= i;
        result |= bit << (32 - i - 1);
    }
    return result;
}