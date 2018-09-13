FROM openjdk:8-jdk-alpine

ARG ARTIFACT_ID
ARG BUILD_DATE
ARG VCS_URL
ARG VCS_REF
ARG VCS_SLUG
ARG VENDOR
ARG VERSION
ARG SCHEMA_VERSION

ENV ARTIFACT_ID="${ARTIFACT_ID}"
ENV VERSION="${VERSION}"

LABEL org.label-schema.build-date="${BUILD_DATE}"
LABEL org.label-schema.vcs-url="${VCS_URL}"
LABEL org.label-schema.vcs-ref="${VCS_REF}"
LABEL org.label-schema.vcs-slug="${VCS_SLUG}"
LABEL org.label-schema.vendor="${VENDOR}"
LABEL org.label-schema.version="${VERSION}"
LABEL org.label-schema.schema-version="${SCHEMA_VERSION}"
LABEL org.label-schema.id="${ARTIFACT_ID}"

ADD maven/${ARTIFACT_ID}*.jar /opt/famc/${ARTIFACT_ID}.jar
