void kmp_init(const char *s, int *prefix, size_t size) {
    prefix[0] = 0;
    for (size_t i = 1; i < size; ++i) {
        if (s[i] == s[prefix[i - 1]])
            prefix[i] = prefix[i - 1] + 1;
        else {
            int j = i - 1;
            while (prefix[j] > 0 && s[prefix[j]] != s[i])
                j = prefix[j] - 1;
            if (prefix[j] > 0)
                prefix[i] = prefix[j] + 1;
            else {
                prefix[i] = (s[i] == s[0]);
            }
        }
    }
}