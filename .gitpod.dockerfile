FROM gitpod/workspace-full

# Install custom tools, runtime, etc.
RUN sudo apt-get update \
    && sudo apt-get install -y \
        snapd \
    && sudo rm -rf /var/lib/apt/lists/*

RUN pip install pytest

RUN wget https://github.com/exercism/cli/releases/download/v3.0.13/exercism-3.0.13-linux-x86_64.tar.gz 
RUN tar -xf exercism-3.0.13-linux-x86_64.tar.gz 
RUN sudo mv exercism /usr/local/bin
