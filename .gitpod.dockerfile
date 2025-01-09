FROM gitpod/workspace-full

ARG EXERCISM_VERSION=3.5.4

# Install custom tools, runtime, etc.
RUN sudo apt-get update \
    && sudo apt-get install -y \
        snapd \
    && sudo rm -rf /var/lib/apt/lists/*

# Python
RUN pip install pytest

# SDKman

RUN mkdir -p /home/gitpod/.sdkman/etc
RUN cat > /home/gitpod/.sdkman/etc/config <<EOF
sdkman_auto_answer=true
sdkman_auto_complete=true
sdkman_auto_env=true
sdkman_beta_channel=false
sdkman_colour_enable=true
sdkman_curl_connect_timeout=7
sdkman_curl_max_time=10
sdkman_debug_mode=false
sdkman_insecure_ssl=false
sdkman_rosetta2_compatible=true
sdkman_auto_update=true
sdkman_checksum_enable=true
sdkman_selfupdate_feature=true
EOF

# Exercism
RUN wget https://github.com/exercism/cli/releases/download/v${EXERCISM_VERSION}/exercism-${EXERCISM_VERSION}-linux-x86_64.tar.gz
RUN tar -xf exercism-${EXERCISM_VERSION}-linux-x86_64.tar.gz
RUN sudo mv exercism /usr/local/bin

